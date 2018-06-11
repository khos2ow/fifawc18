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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.khosrow.fifawc.common.util.Stage;
import lombok.Data;
import lombok.experimental.NonFinal;

@Entity
@Table(name = "matches")
@Data
public class Match {
    public static final Match NULL = new Match();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 36)
    @Column(length = 36)
    private String uuid;

    @NotBlank
    private String number;

    @NotBlank
    private Stage stage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_1_id", nullable = true)
    private Team team1;

    @NotBlank
    @Column(name = "team1_indicator", nullable = true)
    private String team1Indicator;

    @NotBlank
    @Column(name = "team1_goals")
    private Integer team1Goals;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_2_id", nullable = true)
    private Team team2;

    @NotBlank
    @Column(name = "team2_indicator", nullable = true)
    private String team2Indicator;

    @NotBlank
    @Column(name = "team2_goals")
    private Integer team2Goals;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "match_date")
    private Date matchDate;
}
