package io.khosrow.fifawc.common.dto;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import lombok.Data;

import io.khosrow.fifawc.domain.Country;

@Data
public class CountryDTO {
    private String uuid;
    private String name;
    private String iso2;
    private String iso3;
    private String flag;

    public String getFlag() {
        return String.format("/assets/img/flags/%s.gif", flag);
    }

    public static CountryDTO of(Country country) {
        return new ModelMapper().map(country, CountryDTO.class);
    }

    public static CountryDTO of(Optional<Country> country) {
        return of(country.orElse(Country.NULL));
    }
}
