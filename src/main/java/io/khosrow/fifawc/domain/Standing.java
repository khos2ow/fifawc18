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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.experimental.NonFinal;

@Entity
@Table(name = "standing")
@Data
public class Standing implements Comparable<Standing> {
    public static final Standing NULL = new Standing();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 36)
    @Column(length = 36)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @NotBlank
    private Integer games;

    @NotBlank
    private Integer wins;

    @NotBlank
    private Integer draws;

    @NotBlank
    private Integer loses;

    @NotBlank
    @Column(name = "goals_for")
    private Integer goalsFor;

    @NotBlank
    @Column(name = "goals_against")
    private Integer goalsAgainst;

    @NotBlank
    @Column(name = "goals_diff")
    private Integer goalsDiff;

    @NotBlank
    private Integer points;

    @Override
    public int compareTo(Standing that) {
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
