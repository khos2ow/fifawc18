package io.khosrow.fifawc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.khosrow.fifawc.common.util.UserLoginType;
import lombok.Data;
import lombok.experimental.NonFinal;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @NonFinal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String email;
    private String principalId;
    private String photo;
    private LocalDateTime created;
    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private UserLoginType loginType;

    @Column(name = "points")
    private Integer points;
}