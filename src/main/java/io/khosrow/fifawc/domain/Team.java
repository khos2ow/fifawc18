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
@Table(name = "team")
@Data
public class Team {
    public static final Team NULL = new Team();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 36)
    @Column(length = 36)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "fifa_rank", nullable = true)
    private Integer fifaRank;

    @Column(name = "fifa_score", nullable = true)
    private Integer fifaScore;
}
