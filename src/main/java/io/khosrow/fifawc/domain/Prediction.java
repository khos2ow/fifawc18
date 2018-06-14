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

@Entity
@Table(name = "predictions")
@Data
public class Prediction {
    public static final Prediction NULL = new Prediction();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 36)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "number")
    private String number;

    @Column(name = "team1_goals")
    private Integer team1Goals;

    @Column(name = "team1_penalty_goals")
    private Integer team1PenaltyGoals;

    @Column(name = "team2_goals")
    private Integer team2Goals;

    @Column(name = "team2_penalty_goals")
    private Integer team2PenaltyGoals;
}
