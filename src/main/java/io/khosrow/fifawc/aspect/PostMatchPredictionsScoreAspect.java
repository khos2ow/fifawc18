package io.khosrow.fifawc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.util.Result;
import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.repo.MatchRepository;
import io.khosrow.fifawc.repo.UserRepository;
import io.khosrow.fifawc.service.PredictionService;

@Aspect
@Component
public class PostMatchPredictionsScoreAspect {
    private final PredictionService predictionService;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostMatchPredictionsScoreAspect(PredictionService predictionService, MatchRepository matchRepository, UserRepository userRepository) {
        this.predictionService = predictionService;
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    /**
     * Update User's score points based on the result of the match and their predictions:
     * 
     * 12 points: correct result (win, draw)
     * 18 points: correct result and correct goals difference (not applicable for draw match)
     * 32 points: spot on match result (win, draw)
     */
    @Around("@annotation(io.khosrow.fifawc.common.annotation.UpdatePredictionScore)")
    public Object around(ProceedingJoinPoint jpnt) throws Throwable {
        // execute the point-cut
        MatchDTO match = (MatchDTO)jpnt.proceed();

        if (!match.getStage().equals(Stage.NULL.getTitle())) {
            Match entity = matchRepository.findByUuid(match.getUuid()).get();
            Result matchResult = entity.getResult();

            predictionService.getAllPredictionsByNumber(match.getNumber()).forEach(prediction -> {
                Integer points = 0;
                Result predictionResult = prediction.getResult();

                if (matchResult.equals(predictionResult)) {
                    if (matchResult.equals(Result.DRAW)) {
                        if (match.getTeam1Goals() == prediction.getTeam1Goals()) {
                            // exact result
                            points = 32;
                        } else {
                            // correct result
                            points = 12;
                        }
                    } else {
                        if (match.getTeam1Goals() == prediction.getTeam1Goals() && match.getTeam2Goals() == prediction.getTeam2Goals()) {
                            // exact result
                            points = 32;
                        } else if (match.getTeam1Goals() - match.getTeam2Goals() == prediction.getTeam1Goals() - prediction.getTeam1Goals()) {
                            // correct result and correct goals difference
                            points = 18;
                        } else {
                            // correct result
                            points = 12;
                        }
                    }

                    User user = prediction.getUser();

                    user.setPoints(user.getPoints() + points);

                    userRepository.save(user);
                }
            });

        }

        return match;
    }
}
