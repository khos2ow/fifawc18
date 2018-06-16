package io.khosrow.fifawc.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.dto.PredictionDTO;
import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Group;
import io.khosrow.fifawc.domain.Prediction;
import io.khosrow.fifawc.domain.PredictionStanding;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.repo.PredictionRepository;
import io.khosrow.fifawc.repo.PredictionStandingRepository;

@Service
public class PredictionService {
    private final PredictionRepository repository;
    private final PredictionStandingRepository predictionStandingRepository;
    private final MatchService matchService;
    private final StandingService standingService;

    @Autowired
    public PredictionService(PredictionRepository repository, PredictionStandingRepository predictionStandingRepository, MatchService matchService, StandingService standingService) {
        this.repository = repository;
        this.predictionStandingRepository = predictionStandingRepository;
        this.matchService = matchService;
        this.standingService = standingService;
    }

    /**
     * Get Prediction of logged in User
     *
     * @param user to look up prediction for
     *
     * @return list of Prediction
     */
    public List<PredictionDTO> getPredictionsOfUser(User user) {
        return repository.findByUser(user)
                .stream()
                .map(PredictionDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Get list of matches in provided group
     *
     * @param group instance look up match for
     *
     * @return list of MatchDTO of current Group
     */
    public List<MatchDTO> getMatchesByGroup(Optional<Group> group, User user) {
        if (!group.isPresent()) {
            return Collections.emptyList();
        }

        return repository.findByGroupIdAndUserId(group.get().getId(), user.getId())
                .stream()
                .map(MatchDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Get list of matches in provided stage
     *
     * @param name of the stage to look up match for
     * @param user to filter for
     *
     * @return list of MatchDTO of current Stage
     */
    public List<MatchDTO> getMatchesByStage(String name, User user) {
        Stage stage = Stage.of(name);

        if (stage == null) {
            return Collections.emptyList();
        }

        return repository.findByStageAndUserId(stage, user.getId())
                .stream()
                .map(MatchDTO::of)
                .collect(Collectors.toList());
    }

    /**
     * Save Prediction of logged in User
     *
     * @param payload of the prediction
     * @param user    who are making the prediction
     *
     * @return true if successful
     */
    public boolean savePredictionsOfUser(List<PredictionDTO> payload, User user) {
        payload.forEach(p -> {
            Optional<Prediction> entity = repository.findByNumberAndUserId(p.getNumber(), user.getId());

            if (entity.isPresent()) {
                Prediction prediction = entity.get();

                // something's not right
                if (prediction.getTeam1() == null || prediction.getTeam2() == null) {
                    return;
                }

                // cannot add/edit matches that are already past
                ZonedDateTime NOW = ZonedDateTime.now(ZoneId.of("America/New_York"));
                ZonedDateTime matchDate = prediction.getMatchDate().toInstant().atZone(ZoneId.of("America/New_York"));

                if (NOW.compareTo(matchDate) > 0) {
                    return;
                }

                if (p.getTeam1Goals() != null) {
                    prediction.setTeam1Goals(p.getTeam1Goals());
                }

                if (p.getTeam1PenaltyGoals() != null) {
                    prediction.setTeam1PenaltyGoals(p.getTeam1PenaltyGoals());
                }

                if (p.getTeam2Goals() != null) {
                    prediction.setTeam2Goals(p.getTeam2Goals());
                }

                if (p.getTeam2PenaltyGoals() != null) {
                    prediction.setTeam2PenaltyGoals(p.getTeam2PenaltyGoals());
                }

                repository.save(prediction);
            }
        });

        resetPredictionStandings(user);

        // update group standing and knock-out stages
        List<Prediction> findByUser = repository.findByUser(user);

        findByUser.forEach(prediction -> {
            // update group standings
            if (prediction.getStage().equals(Stage.GROUPS)) {
                Pair<Team, Team> proceedNextRound = updateStanding(prediction, user);

                // update proceeded team to the next round (if possible)
                if (proceedNextRound.getFirst() != Team.NULL && proceedNextRound.getSecond() != Team.NULL) {
                    String groupName = prediction.getGroup().getName();

                    // Team standing #1 proceeded to next round
                    Optional<Prediction> team1NextRound = repository.findByTeam1IndicatorAndUserId("1" + groupName, user.getId());

                    if (team1NextRound.isPresent()) {
                        Prediction nextRoundMatch = team1NextRound.get();
                        nextRoundMatch.setTeam1(proceedNextRound.getFirst());
                        repository.save(nextRoundMatch);
                    }

                    // Team standing #2 proceeded to next round
                    Optional<Prediction> team2NextRound = repository.findByTeam2IndicatorAndUserId("2" + groupName, user.getId());

                    if (team2NextRound.isPresent()) {
                        Prediction nextRoundMatch = team2NextRound.get();
                        nextRoundMatch.setTeam2(proceedNextRound.getSecond());
                        repository.save(nextRoundMatch);
                    }
                }
            }

            // update knock out stages
            else {
                // Winner Team proceeded to next round
                Optional<Prediction> nextRound = repository.findByTeam1IndicatorAndUserId("W" + prediction.getNumber(), user.getId());
                Team winner = null;

                if (prediction.getTeam1() == null || prediction.getTeam2() == null) {
                    return;
                }
                if (prediction.getTeam1Goals() == null || prediction.getTeam2Goals() == null) {
                    return;
                } else {
                    if (prediction.getTeam1PenaltyGoals() == null || prediction.getTeam1PenaltyGoals() == null) {
                        return;
                    }
                }

                if (prediction.getTeam1Goals() == prediction.getTeam2Goals()) {
                    winner = prediction.getTeam1PenaltyGoals() > prediction.getTeam2PenaltyGoals() ? prediction.getTeam1() : prediction.getTeam2();
                } else {
                    winner = prediction.getTeam1Goals() > prediction.getTeam2Goals() ? prediction.getTeam1() : prediction.getTeam2();
                }

                if (nextRound.isPresent()) {
                    Prediction nextRoundMatch = nextRound.get();
                    nextRoundMatch.setTeam1(winner);
                    repository.save(nextRoundMatch);
                } else {
                    nextRound = repository.findByTeam2IndicatorAndUserId("W" + prediction.getNumber(), user.getId());

                    if (nextRound.isPresent()) {
                        Prediction nextRoundMatch = nextRound.get();
                        nextRoundMatch.setTeam2(winner);
                        repository.save(nextRoundMatch);
                    }
                }

                // Loser Team will proceed to playoff *only* if stage is semi-finals
                if (prediction.getStage().equals(Stage.SEMI_FINALS)) {
                    // Winner Team proceeded to next round
                    Optional<Prediction> playoffRound = repository.findByTeam1IndicatorAndUserId("L" + prediction.getNumber(), user.getId());
                    Team loser = null;

                    if (prediction.getTeam1Goals() == prediction.getTeam2Goals()) {
                        loser = prediction.getTeam1PenaltyGoals() < prediction.getTeam2PenaltyGoals() ? prediction.getTeam1() : prediction.getTeam2();
                    } else {
                        loser = prediction.getTeam1Goals() < prediction.getTeam2Goals() ? prediction.getTeam1() : prediction.getTeam2();
                    }

                    if (playoffRound.isPresent()) {
                        Prediction nextRoundMatch = playoffRound.get();
                        nextRoundMatch.setTeam1(loser);
                        repository.save(nextRoundMatch);
                    } else {
                        playoffRound = repository.findByTeam2IndicatorAndUserId("L" + prediction.getNumber(), user.getId());

                        if (playoffRound.isPresent()) {
                            Prediction nextRoundMatch = playoffRound.get();
                            nextRoundMatch.setTeam2(loser);
                            repository.save(nextRoundMatch);
                        }
                    }
                }
            }
        });

        return true;
    }

    /**
     * Generate placeholder list of Predictions for new User
     *
     * @param user to generate prediction placeholder for
     */
    public void generatePredictionForNewUser(User user) {
        if (user == null) {
            return;
        }

        List<Prediction> predictions = repository.findByUser(user);

        if (!predictions.isEmpty()) {
            return;
        }

        matchService.getAllMaches().forEach(m -> {
            Prediction prediction = new Prediction();

            prediction.setUuid(UUID.randomUUID().toString());
            prediction.setUser(user);
            prediction.setNumber(m.getNumber());
            prediction.setStage(m.getStage());
            prediction.setGroup(m.getGroup());
            prediction.setTeam1(m.getStage().equals(Stage.GROUPS) ? m.getTeam1() : null);
            prediction.setTeam1Indicator(m.getTeam1Indicator());
            prediction.setTeam1Goals(null);
            prediction.setTeam1PenaltyGoals(null);
            prediction.setTeam2(m.getStage().equals(Stage.GROUPS) ? m.getTeam2() : null);
            prediction.setTeam2Indicator(m.getTeam2Indicator());
            prediction.setTeam2Goals(null);
            prediction.setTeam2PenaltyGoals(null);
            prediction.setMatchDate(m.getMatchDate());

            repository.save(prediction);
        });
    }

    /**
     * Generate placeholder list of Predictions Standing for new User
     *
     * @param user to generate prediction standing placeholder for
     */
    public void generatePredictionStandingForNewUser(User user) {
        if (user == null) {
            return;
        }

        List<PredictionStanding> predictionStandings = predictionStandingRepository.findByUser(user);

        if (!predictionStandings.isEmpty()) {
            return;
        }

        standingService.getAllStandings().forEach(s -> {
            PredictionStanding standing = new PredictionStanding();

            standing.setUuid(UUID.randomUUID().toString());
            standing.setUser(user);
            standing.setGroup(s.getGroup());
            standing.setTeam(s.getTeam());
            standing.setGames(0);
            standing.setWins(0);
            standing.setDraws(0);
            standing.setLoses(0);
            standing.setGoalsFor(0);
            standing.setGoalsAgainst(0);
            standing.setGoalsDiff(0);
            standing.setPoints(0);

            predictionStandingRepository.save(standing);
        });
    }

    /**
     * Reset Predictions of User to re-populate it
     *
     * @param user instance to reset their prediction
     */
    private void resetPredictionStandings(User user) {
        predictionStandingRepository.findByUser(user)
            .forEach(standing -> {
                standing.setGames(0);
                standing.setWins(0);
                standing.setDraws(0);
                standing.setLoses(0);
                standing.setGoalsFor(0);
                standing.setGoalsAgainst(0);
                standing.setGoalsDiff(0);
                standing.setPoints(0);

                predictionStandingRepository.save(standing);
            });
    }

    /**
     * Update Group Standing based the Match result
     *
     * @param prediction instance
     *
     * @return true if group stage was finished after this match, false if not
     */
    private Pair<Team, Team> updateStanding(Prediction prediction, User user) {
        Optional<PredictionStanding> team1Standing = predictionStandingRepository.findByTeamIdAndUserId(prediction.getTeam1().getId(), user.getId());
        updateTeamStanding(team1Standing, prediction.getTeam1Goals(), prediction.getTeam2Goals());

        Optional<PredictionStanding> team2Standing = predictionStandingRepository.findByTeamIdAndUserId(prediction.getTeam2().getId(), user.getId());
        updateTeamStanding(team2Standing, prediction.getTeam2Goals(), prediction.getTeam1Goals());

        // check if this match is the latest one in particular group staging
        List<PredictionStanding> standing = predictionStandingRepository.findByGroupIdAndUserId(prediction.getGroup().getId(), user.getId())
                                                .stream()
                                                .sorted()
                                                .collect(Collectors.toList());

        PredictionStanding notCompletedMatch = standing.stream()
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
    private void updateTeamStanding(Optional<PredictionStanding> standing, Integer homeGoals, Integer awayGoals) {
        if (homeGoals == null && awayGoals == null) {
            return;
        }

        if (standing.isPresent()) {
            PredictionStanding entity = standing.get();

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

            predictionStandingRepository.save(entity);
        }
    }
}
