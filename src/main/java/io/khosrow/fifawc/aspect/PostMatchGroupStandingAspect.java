package io.khosrow.fifawc.aspect;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.repo.MatchRepository;
import io.khosrow.fifawc.repo.PredictionRepository;
import io.khosrow.fifawc.service.PredictionService;
import io.khosrow.fifawc.service.StandingService;

@Aspect
@Component
public class PostMatchGroupStandingAspect {
    private final StandingService standingService;
    private final MatchRepository matchRepository;
    private final PredictionService predictionService;
    private final PredictionRepository predictionRepository;

    @Autowired
    public PostMatchGroupStandingAspect(StandingService standingService, MatchRepository matchRepository, PredictionService predictionService, PredictionRepository predictionRepository) {
        this.standingService = standingService;
        this.matchRepository = matchRepository;
        this.predictionService = predictionService;
        this.predictionRepository = predictionRepository;
    }

    @Around("@annotation(io.khosrow.fifawc.common.annotation.UpdateGroupStanding)")
    public Object around(ProceedingJoinPoint jpnt) throws Throwable {
        // execute the point-cut
        MatchDTO match = (MatchDTO) jpnt.proceed();

        // update group standings
        if (!match.getStage().equals(Stage.NULL.getTitle()) && match.getStage().equals(Stage.GROUPS.getTitle())) {
            Match entity = matchRepository.findByUuid(match.getUuid()).get();
            Pair<Team, Team> proceedNextRound = standingService.updateStanding(entity);

            // update proceeded team to the next round (if possible)
            if (proceedNextRound.getFirst() != Team.NULL && proceedNextRound.getSecond() != Team.NULL) {
                String groupName = match.getGroup().getName();

                // Team standing #1 proceeded to next round
                Optional<Match> team1NextRound = matchRepository.findByTeam1Indicator("1" + groupName);

                if (team1NextRound.isPresent()) {
                    Match nextRoundMatch = team1NextRound.get();
                    nextRoundMatch.setTeam1(proceedNextRound.getFirst());
                    matchRepository.save(nextRoundMatch);

                    updatePredictionsNextRound(nextRoundMatch.getNumber(), proceedNextRound.getFirst(), null);
                }

                // Team standing #2 proceeded to next round
                Optional<Match> team2NextRound = matchRepository.findByTeam2Indicator("2" + groupName);

                if (team2NextRound.isPresent()) {
                    Match nextRoundMatch = team2NextRound.get();
                    nextRoundMatch.setTeam2(proceedNextRound.getSecond());
                    matchRepository.save(nextRoundMatch);

                    updatePredictionsNextRound(nextRoundMatch.getNumber(), null, proceedNextRound.getSecond());
                }
            }
        }

        return match;
    }

    /**
     * Update advanced team to the next round for all the users' predictions
     *
     * @param matchNumber to update
     * @param team1 which advanded to next round (can be null)
     * @param team2 which advanded to next round (can be null)
     */
    private void updatePredictionsNextRound(final String matchNumber, Team team1, Team team2) {
        predictionService.getAllPredictionsByNumber(matchNumber).forEach(prediction -> {
            if (team1 != null) {
                prediction.setTeam1(team1);
            }
            if (team2 != null) {
                prediction.setTeam2(team2);
            }

            predictionRepository.save(prediction);
        });
    }
}
