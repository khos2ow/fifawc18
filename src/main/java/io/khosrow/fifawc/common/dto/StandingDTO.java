package io.khosrow.fifawc.common.dto;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import lombok.Data;

import io.khosrow.fifawc.domain.PredictionStanding;
import io.khosrow.fifawc.domain.Standing;

@Data
public class StandingDTO {
    private TeamDTO team;
    private Integer games;
    private Integer wins;
    private Integer draws;
    private Integer loses;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer goalsDiff;
    private Integer points;

    public static StandingDTO of(Standing standing) {
        return new ModelMapper().map(standing, StandingDTO.class);
    }

    public static StandingDTO of(Optional<Standing> standing) {
        return of(standing.orElse(Standing.NULL));
    }

    public static StandingDTO of(PredictionStanding standing) {
        return new ModelMapper().map(standing, StandingDTO.class);
    }
}
