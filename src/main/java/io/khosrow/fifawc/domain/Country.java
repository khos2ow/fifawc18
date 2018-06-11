package io.khosrow.fifawc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.experimental.NonFinal;

@Entity
@Table(name = "country")
@Data
public class Country {
    public static final Country NULL = new Country();

    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 36)
    @Column(length = 36)
    private String uuid;

    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "iso2", length = 2)
    private String iso2;

    @NotBlank
    @Column(name = "iso3", length = 3)
    private String iso3;

    @NotBlank
    @Column(name = "flag")
    private String flag;
}
