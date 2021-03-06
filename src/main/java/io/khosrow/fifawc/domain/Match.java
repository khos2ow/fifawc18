package io.khosrow.fifawc.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.experimental.NonFinal;

import io.khosrow.fifawc.common.util.IMatch;
import io.khosrow.fifawc.common.util.Stage;

@Entity
@Table(name = "matches")
@Data
public class Match implements IMatch {
    public static final Match NULL = Match.buildNull();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 36)
    private String uuid;

    @Column(name = "number")
    private String number;

    @Column(name = "stage")
    private Stage stage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_1_id", nullable = true)
    private Team team1;

    @Column(name = "team1_indicator", nullable = true)
    private String team1Indicator;

    @Column(name = "team1_goals")
    private Integer team1Goals;

    @Column(name = "team1_penalty_goals")
    private Integer team1PenaltyGoals;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_2_id", nullable = true)
    private Team team2;

    @Column(name = "team2_indicator", nullable = true)
    private String team2Indicator;

    @Column(name = "team2_goals")
    private Integer team2Goals;

    @Column(name = "team2_penalty_goals")
    private Integer team2PenaltyGoals;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "match_date")
    private Date matchDate;

    private static Match buildNull() {
        Match m = new Match();
        m.setStage(Stage.NULL);
        return m;
    }
}
