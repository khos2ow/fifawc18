package io.khosrow.fifawc.common.util;

import java.util.Date;

import io.khosrow.fifawc.domain.Group;
import io.khosrow.fifawc.domain.Team;

public interface IMatch {
    Integer getId();

    String getUuid();

    String getNumber();

    Stage getStage();

    Group getGroup();

    Team getTeam1();

    String getTeam1Indicator();

    Integer getTeam1Goals();

    Integer getTeam1PenaltyGoals();

    Team getTeam2();

    String getTeam2Indicator();

    Integer getTeam2Goals();

    Integer getTeam2PenaltyGoals();

    Date getMatchDate();
}
