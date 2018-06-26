package io.khosrow.fifawc.common.dto;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import lombok.Data;
import io.khosrow.fifawc.common.util.IStanding;
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
    private boolean proceeded = false;

    public static <T extends IStanding> StandingDTO of(T standing) {
        return new ModelMapper().map(standing, StandingDTO.class);
    }

    public static StandingDTO of(Optional<Standing> standing) {
        return of(standing.orElse(Standing.NULL));
    }
}
