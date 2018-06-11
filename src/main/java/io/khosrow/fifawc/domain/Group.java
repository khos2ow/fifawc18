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
@Table(name = "groups")
@Data
public class Group {
    public static final Group NULL = new Group();

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
}
