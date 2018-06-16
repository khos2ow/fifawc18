package io.khosrow.fifawc.common.dto;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import lombok.Data;

import io.khosrow.fifawc.domain.Team;

@Data
public class TeamDTO {
    private String uuid;
    private CountryDTO country;
    private int fifaRank;
    private int fifaScore;

    public static TeamDTO of(Team team) {
        return new ModelMapper().map(team, TeamDTO.class);
    }

    public static TeamDTO of(Optional<Team> team) {
        return of(team.orElse(Team.NULL));
    }
}
