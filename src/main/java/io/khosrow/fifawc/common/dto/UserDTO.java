package io.khosrow.fifawc.common.dto;

import org.modelmapper.ModelMapper;

import lombok.Data;

import io.khosrow.fifawc.domain.User;

@Data
public class UserDTO {
    private String fullName;
    private String principalId;
    private String photo;
    private Integer points;

    public static UserDTO of(User user) {
        return new ModelMapper().map(user, UserDTO.class);
    }
}
