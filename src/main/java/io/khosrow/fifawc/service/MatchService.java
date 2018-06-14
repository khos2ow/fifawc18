package io.khosrow.fifawc.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Group;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.repo.MatchRepository;

@Service
public class MatchService {
    private final MatchRepository repository;
    private final StandingService standingService;
    private final TeamService teamService;

    @Autowired
    public MatchService(MatchRepository repository, StandingService standingService, TeamService teamService) {
        this.repository = repository;
        this.standingService = standingService;
        this.teamService = teamService;
    }

    /**
     * Get list of all the matches
     * 
     * @return list of Match
     */
    public List<Match> getAllMaches() {
        return repository.findAll();
    }

    /**
     * Get list of matches in provided stage
     * 
     * @param name of the stage to look up match for
     * 
     * @return list of MatchDTO of current Stage
     */
    public List<MatchDTO> getMatchesByStage(String name) {
        Stage stage = Stage.of(name);

        if (stage == null) {
            return Collections.emptyList();
        }

        return repository.findByStage(stage)
                .stream()
                .map(MatchDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Get list of matches in provided group
     * 
     * @param group instance look up match for
     * 
     * @return list of MatchDTO of current Group
     */
    public List<MatchDTO> getMatchesByGroup(Optional<Group> group) {
        if (!group.isPresent()) {
            return Collections.emptyList();
        }

        return repository.findByGroupId(group.get().getId())
                .stream()
                .map(MatchDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Save a Match result by its UUID
     * 
     * @param uuid of the match
     * @param payload of the result
     * 
     * @return saved MatchDTO instance
     */
    public MatchDTO saveMatchResult(String uuid, MatchDTO payload) {
        Optional<Match> match = repository.findByUuid(uuid);

        return saveMatch(match, payload);
    }

    /**
     * Save a Match result between 'home' and 'away' team by their UUIDs
     * 
     * @param homeUuid to look up Team
     * @param awayUuid to look up Team
     * @param payload of the result
     * 
     * @return saved MatchDTO instance
     */
    public MatchDTO saveMatchResult(String homeUuid, String awayUuid, MatchDTO payload) {
        Optional<Team> home = teamService.getTeamById(homeUuid);
        Optional<Team> away = teamService.getTeamById(awayUuid);

        if (!home.isPresent() || !away.isPresent()) {
            return MatchDTO.of(Match.NULL);
        }

        Optional<Match> match = repository.findByTeam1AndTeam2(home.get(), away.get());

        return saveMatch(match, payload);
    }

    /**
     * Save Match result
     * 
     * @param match optional instance
     * @param payload of the result
     * 
     * @return saved MatchDTO instance or Match.NULL if something goes wrong
     */
    private MatchDTO saveMatch(Optional<Match> match, MatchDTO payload) {
        if (!match.isPresent()) {
            return MatchDTO.of(Match.NULL);
        }

        Match entity = match.get();

        // team goals validation
        if (payload.getTeam1Goals() == null || payload.getTeam1Goals() < 0) {
            return MatchDTO.of(Match.NULL);
        } else if (payload.getTeam2Goals() == null || payload.getTeam2Goals() < 0) {
            return MatchDTO.of(Match.NULL);
        } else if (payload.getTeam1PenaltyGoals() == null || payload.getTeam1PenaltyGoals() < 0) {
            return MatchDTO.of(Match.NULL);
        } else if (payload.getTeam2PenaltyGoals() == null || payload.getTeam2PenaltyGoals() < 0) {
            return MatchDTO.of(Match.NULL);
        }

        entity.setTeam1Goals(payload.getTeam1Goals());
        entity.setTeam1PenaltyGoals(payload.getTeam1PenaltyGoals());
        entity.setTeam2Goals(payload.getTeam2Goals());
        entity.setTeam2PenaltyGoals(payload.getTeam2PenaltyGoals());

        // save match result
        repository.save(entity);

        // update group standings
        if (entity.getStage().equals(Stage.GROUPS)) {
            Pair<Team, Team> proceedNextRound = standingService.updateStanding(entity);

            // update proceeded team to the next round (if possible)
            if (proceedNextRound.getFirst() != Team.NULL && proceedNextRound.getSecond() != Team.NULL) {
                String groupName = entity.getGroup().getName();

                // Team standing #1 proceeded to next round
                Optional<Match> team1NextRound = repository.findByTeam1Indicator("1" + groupName);

                if (team1NextRound.isPresent()) {
                    Match nextRoundMatch = team1NextRound.get();
                    nextRoundMatch.setTeam1(proceedNextRound.getFirst());
                    repository.save(nextRoundMatch);
                }

                // Team standing #2 proceeded to next round
                Optional<Match> team2NextRound = repository.findByTeam2Indicator("2" + groupName);

                if (team2NextRound.isPresent()) {
                    Match nextRoundMatch = team2NextRound.get();
                    nextRoundMatch.setTeam2(proceedNextRound.getSecond());
                    repository.save(nextRoundMatch);
                }
            }
        }

        // update knock out stages
        else {
            // Winner Team proceeded to next round
            Optional<Match> nextRound = repository.findByTeam1Indicator("W" + entity.getNumber());
            Team winner = null;

            if (entity.getTeam1Goals() == entity.getTeam2Goals()) {
                winner = entity.getTeam1PenaltyGoals() > entity.getTeam2PenaltyGoals() ? entity.getTeam1() : entity.getTeam2();
            } else {
                winner = entity.getTeam1Goals() > entity.getTeam2Goals() ? entity.getTeam1() : entity.getTeam2();
            }

            if (nextRound.isPresent()) {
                Match nextRoundMatch = nextRound.get();
                nextRoundMatch.setTeam1(winner);
                repository.save(nextRoundMatch);
            } else {
                nextRound = repository.findByTeam2Indicator("W" + entity.getNumber());

                if (nextRound.isPresent()) {
                    Match nextRoundMatch = nextRound.get();
                    nextRoundMatch.setTeam2(winner);
                    repository.save(nextRoundMatch);
                }
            }

            // Loser Team will proceed to playoff *only* if stage is semi-finals
            if (entity.getStage().equals(Stage.SEMI_FINALS)) {
                // Winner Team proceeded to next round
                Optional<Match> playoffRound = repository.findByTeam1Indicator("L" + entity.getNumber());
                Team loser = null;

                if (entity.getTeam1Goals() == entity.getTeam2Goals()) {
                    loser = entity.getTeam1PenaltyGoals() < entity.getTeam2PenaltyGoals() ? entity.getTeam1() : entity.getTeam2();
                } else {
                    loser = entity.getTeam1Goals() < entity.getTeam2Goals() ? entity.getTeam1() : entity.getTeam2();
                }

                if (playoffRound.isPresent()) {
                    Match nextRoundMatch = playoffRound.get();
                    nextRoundMatch.setTeam1(loser);
                    repository.save(nextRoundMatch);
                } else {
                    playoffRound = repository.findByTeam2Indicator("L" + entity.getNumber());

                    if (playoffRound.isPresent()) {
                        Match nextRoundMatch = playoffRound.get();
                        nextRoundMatch.setTeam2(loser);
                        repository.save(nextRoundMatch);
                    }
                }
            }
        }

        return MatchDTO.of(entity);
    }
}
