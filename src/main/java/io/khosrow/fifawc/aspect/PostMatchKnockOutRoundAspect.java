package io.khosrow.fifawc.aspect;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.repo.MatchRepository;
import io.khosrow.fifawc.repo.PredictionRepository;
import io.khosrow.fifawc.repo.TeamRepository;
import io.khosrow.fifawc.service.PredictionService;

@Aspect
@Component
public class PostMatchKnockOutRoundAspect {
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final PredictionService predictionService;
    private final PredictionRepository predictionRepository;

    @Autowired
    public PostMatchKnockOutRoundAspect(MatchRepository matchRepository, TeamRepository teamRepository, PredictionService predictionService, PredictionRepository predictionRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.predictionService = predictionService;
        this.predictionRepository = predictionRepository;
    }

    @Around("@annotation(io.khosrow.fifawc.common.annotation.UpdateKnockOutRound)")
    public Object around(ProceedingJoinPoint jpnt) throws Throwable {
        // execute the point-cut
        MatchDTO match = (MatchDTO)jpnt.proceed();

        // Winner Team proceeded to next round
        if (!match.getStage().equals(Stage.NULL.getTitle()) && !match.getStage().equals(Stage.GROUPS.getTitle())) {
            proceedTeamToNextRound(match, "W");
        }

        // Loser Team will match to playoff *only* if stage is semi-finals
        if (!match.getStage().equals(Stage.NULL.getTitle()) && match.getStage().equals(Stage.SEMI_FINALS.getTitle())) {
            proceedTeamToNextRound(match, "L");
        }

        return match;
    }

    /**
     * Proceed a Team to the next round based on the result of the Match
     *
     * @param match DTO instance
     * @param indicator of the team to proceed (Winner or Loser [only to playoff])
     */
    private void proceedTeamToNextRound(final MatchDTO match, final String indicator) {
        String winnerUuid = null;

        if (match.getTeam1Goals() == match.getTeam2Goals()) {
            winnerUuid = match.getTeam1PenaltyGoals() > match.getTeam2PenaltyGoals() ? match.getTeam1().getUuid() : match.getTeam2().getUuid();
        } else {
            winnerUuid = match.getTeam1Goals() > match.getTeam2Goals() ? match.getTeam1().getUuid() : match.getTeam2().getUuid();
        }

        Optional<Match> nextRound = matchRepository.findByTeam1Indicator(indicator + match.getNumber());
        Team qualifiedTeam = teamRepository.findByUuid(winnerUuid).orElse(null);

        if (nextRound.isPresent()) {
            Match nextRoundMatch = nextRound.get();
            nextRoundMatch.setTeam1(qualifiedTeam);
            matchRepository.save(nextRoundMatch);

            updatePredictionsNextRound(nextRoundMatch.getNumber(), qualifiedTeam, null);
        } else {
            nextRound = matchRepository.findByTeam2Indicator(indicator + match.getNumber());

            if (nextRound.isPresent()) {
                Match nextRoundMatch = nextRound.get();
                nextRoundMatch.setTeam2(qualifiedTeam);
                matchRepository.save(nextRoundMatch);

                updatePredictionsNextRound(nextRoundMatch.getNumber(), null, qualifiedTeam);
            }
        }
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
