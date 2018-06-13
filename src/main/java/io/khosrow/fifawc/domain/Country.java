package io.khosrow.fifawc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(length = 36)
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "iso2", length = 2)
    private String iso2;

    @Column(name = "iso3", length = 3)
    private String iso3;

    @Column(name = "flag")
    private String flag;
}
