package io.khosrow.fifawc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.StandingDTO;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Standing;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.repo.PredictionStandingRepository;
import io.khosrow.fifawc.repo.StandingRepository;

@Service
public class StandingService {
    private final StandingRepository repository;
    private final PredictionStandingRepository predictionStandingRepository;

    @Autowired
    public StandingService(StandingRepository repository, PredictionStandingRepository predictionStandingRepository) {
        this.repository = repository;
        this.predictionStandingRepository = predictionStandingRepository;
    }

    /**
     * Get list of all the standings
     *
     * @return list of Standing
     */
    public List<Standing> getAllStandings() {
        return repository.findAll();
    }

    /**
     * Get list of Standing teams in provided Group
     *
     * @param id of group to look up standing for
     *
     * @return list of StandingDTO
     */
    public List<StandingDTO> getStandingByGroupId(Integer id, User user) {
        if (user == null) {
            return repository.findByGroupId(id)
                    .stream()
                    .sorted()
                    .map(StandingDTO::of)
                    .collect(Collectors.toList());
        } else {
            return predictionStandingRepository.findByGroupIdAndUserId(id, user.getId())
                    .stream()
                    .sorted()
                    .map(StandingDTO::of)
                    .collect(Collectors.toList());
        }
    }

    /**
     * Update Group Standing based the Match result
     *
     * @param match instance
     *
     * @return true if group stage was finished after this match, false if not
     */
    public Pair<Team, Team> updateStanding(Match match) {
        Optional<Standing> team1Standing = repository.findByTeamId(match.getTeam1().getId());
        updateTeamStanding(team1Standing, match.getTeam1Goals(), match.getTeam2Goals());

        Optional<Standing> team2Standing = repository.findByTeamId(match.getTeam2().getId());
        updateTeamStanding(team2Standing, match.getTeam2Goals(), match.getTeam1Goals());

        // check if this match is the latest one in particular group staging
        List<Standing> standing = repository.findByGroupId(match.getGroup().getId())
                                    .stream()
                                    .sorted()
                                    .collect(Collectors.toList());

        Standing notCompletedMatch = standing.stream()
                                        .filter(s -> s.getGames() < 3)
                                        .findAny()
                                        .orElse(null);

        return notCompletedMatch != null ? Pair.of(Team.NULL, Team.NULL) : Pair.of(standing.get(0).getTeam(), standing.get(1).getTeam());
    }

    /**
     * Update particular Team in Group Standing based on the Match result
     *
     * @param standing
     * @param homeGoals
     * @param awayGoals
     */
    private void updateTeamStanding(Optional<Standing> standing, Integer homeGoals, Integer awayGoals) {
        if (standing.isPresent()) {
            Standing entity = standing.get();

            entity.setGames(entity.getGames() + 1);

            entity.setWins(entity.getWins() + (homeGoals > awayGoals ? 1 : 0));
            entity.setDraws(entity.getDraws() + (homeGoals == awayGoals ? 1 : 0));
            entity.setLoses(entity.getLoses() + (homeGoals < awayGoals ? 1 : 0));

            entity.setGoalsFor(entity.getGoalsFor() + homeGoals);
            entity.setGoalsAgainst(entity.getGoalsAgainst() + awayGoals);
            entity.setGoalsDiff(entity.getGoalsDiff() + (homeGoals - awayGoals));

            Integer points = 0;

            if (homeGoals > awayGoals) {
                points += 3;
            } else if (homeGoals == awayGoals) {
                points += 1;
            }

            entity.setPoints(entity.getPoints() + points);

            repository.save(entity);
        }
    }
}
