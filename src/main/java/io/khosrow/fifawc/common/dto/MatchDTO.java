package io.khosrow.fifawc.common.dto;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Prediction;
import lombok.Data;

@Data
public class MatchDTO {
    private String uuid;
    private String number;
    private Stage stage;
    private GroupDTO group;
    private TeamDTO team1;
    private String team1Indicator;
    private Integer team1Goals;
    private Integer team1PenaltyGoals;
    private TeamDTO team2;
    private String team2Indicator;
    private Integer team2Goals;
    private Integer team2PenaltyGoals;
    private Date matchDate;

    public String getStage() {
        return stage.getTitle();
    }

    public static MatchDTO of(Match match) {
        return new ModelMapper().map(match, MatchDTO.class);
    }

    public static MatchDTO of(Optional<Match> match) {
        return of(match.orElse(Match.NULL));
    }

    public static MatchDTO of(Prediction prediction) {
        return new ModelMapper().map(prediction, MatchDTO.class);
    }
}
