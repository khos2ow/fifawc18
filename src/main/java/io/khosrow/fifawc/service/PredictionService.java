package io.khosrow.fifawc.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.khosrow.fifawc.domain.Prediction;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.repo.PredictionRepository;

@Service
public class PredictionService {
    private final PredictionRepository repository;
    private final MatchService matchService;

    public PredictionService(PredictionRepository repository, MatchService matchService) {
        this.repository = repository;
        this.matchService = matchService;
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
            prediction.setTeam1Goals(null);
            prediction.setTeam1PenaltyGoals(null);
            prediction.setTeam2Goals(null);
            prediction.setTeam2PenaltyGoals(null);

            repository.save(prediction);
        });
    }
}
