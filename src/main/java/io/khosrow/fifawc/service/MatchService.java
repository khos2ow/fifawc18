package io.khosrow.fifawc.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import io.khosrow.fifawc.common.annotation.UpdateGroupStanding;
import io.khosrow.fifawc.common.annotation.UpdateKnockOutRound;
import io.khosrow.fifawc.common.annotation.UpdatePredictionScore;
import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Group;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.repo.MatchRepository;

@Service
public class MatchService {
    private final MatchRepository repository;
    private final TeamService teamService;

    @Autowired
    public MatchService(MatchRepository repository, TeamService teamService) {
        this.repository = repository;
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
     * Get list of matches in provided group
     *
     * @param group instance look up match for
     *
     * @return list of MatchDTO of current Group
     */
    public List<MatchDTO> getMatchesSorted(String sort) {
        return repository.findAll()
                .stream()
                .sorted((m1, m2) -> {
                    if (!Strings.isNullOrEmpty(sort)) {
                        if (sort.equals("date")) {
                            return m1.getMatchDate().compareTo(m2.getMatchDate());
                        }
                    }

                    return m1.getId().compareTo(m2.getId());
                })
                .map(MatchDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Save a Match result by its UUID
     *
     * @param uuid    of the match
     * @param payload of the result
     *
     * @return saved MatchDTO instance
     */
    @UpdateGroupStanding
    @UpdateKnockOutRound
    @UpdatePredictionScore
    public MatchDTO saveMatchResult(String uuid, MatchDTO payload) {
        Optional<Match> match = repository.findByUuid(uuid);

        return saveMatch(match, payload);
    }

    /**
     * Save a Match result between 'home' and 'away' team by their UUIDs
     *
     * @param homeUuid to look up Team
     * @param awayUuid to look up Team
     * @param payload  of the result
     *
     * @return saved MatchDTO instance
     */
    @UpdateGroupStanding
    @UpdateKnockOutRound
    @UpdatePredictionScore
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
     * @param match   optional instance
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
        // TODO
        // if (payload.getTeam1Goals() == null || payload.getTeam1Goals() < 0) {
        // return MatchDTO.of(Match.NULL);
        // } else if (payload.getTeam2Goals() == null || payload.getTeam2Goals() < 0) {
        // return MatchDTO.of(Match.NULL);
        // }
        // if (!entity.getStage().equals(Stage.GROUPS)) {
        // if (payload.getTeam1PenaltyGoals() == null || payload.getTeam1PenaltyGoals()
        // < 0) {
        // return MatchDTO.of(Match.NULL);
        // } else if (payload.getTeam2PenaltyGoals() == null ||
        // payload.getTeam2PenaltyGoals() < 0) {
        // return MatchDTO.of(Match.NULL);
        // }
        // }

        entity.setTeam1Goals(payload.getTeam1Goals());
        entity.setTeam1PenaltyGoals(payload.getTeam1PenaltyGoals());
        entity.setTeam2Goals(payload.getTeam2Goals());
        entity.setTeam2PenaltyGoals(payload.getTeam2PenaltyGoals());

        // save match result
        repository.save(entity);

        return MatchDTO.of(entity);
    }
}
