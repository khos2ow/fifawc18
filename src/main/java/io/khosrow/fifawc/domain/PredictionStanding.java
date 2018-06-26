package io.khosrow.fifawc.domain;

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

import lombok.Data;
import lombok.experimental.NonFinal;

import io.khosrow.fifawc.common.util.IStanding;

@Entity
@Table(name = "predictions_standing")
@Data
public class PredictionStanding extends IStanding implements Comparable<PredictionStanding> {
    public static final PredictionStanding NULL = new PredictionStanding();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 36)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "games")
    private Integer games;

    @Column(name = "wins")
    private Integer wins;

    @Column(name = "draws")
    private Integer draws;

    @Column(name = "loses")
    private Integer loses;

    @Column(name = "goals_for")
    private Integer goalsFor;

    @Column(name = "goals_against")
    private Integer goalsAgainst;

    @Column(name = "goals_diff")
    private Integer goalsDiff;

    @Column(name = "points")
    private Integer points;

    @Override
    public int compareTo(PredictionStanding that) {
        int pointsCompare = that.points.compareTo(this.points);

        if (pointsCompare == 0) {
            int goalsDiffCompare = that.goalsDiff.compareTo(this.goalsDiff);

            if (goalsDiffCompare == 0) {
                return that.goalsFor.compareTo(this.goalsFor);
            }

            return goalsDiffCompare;
        }

        return pointsCompare;
    }
}
