package io.khosrow.fifawc.common.dto;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import io.khosrow.fifawc.domain.Prediction;
import lombok.Data;

@Data
public class PredictionDTO {
    private String uuid;
    private UserDTO user;
    private String number;
    private Integer team1Goals;
    private Integer team1PenaltyGoals;
    private Integer team2Goals;
    private Integer team2PenaltyGoals;

    public static PredictionDTO of(Prediction prediction) {
        return new ModelMapper().map(prediction, PredictionDTO.class);
    }

    public static PredictionDTO of(Optional<Prediction> prediction) {
        return of(prediction.orElse(Prediction.NULL));
    }
}
