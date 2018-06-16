package io.khosrow.fifawc.common.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import lombok.Data;

import io.khosrow.fifawc.domain.Group;

@Data
public class GroupDTO {
    private String uuid;
    private String name;
    private List<StandingDTO> standing = new ArrayList<>();

    public static GroupDTO of(Group group) {
        return new ModelMapper().map(group, GroupDTO.class);
    }

    public static GroupDTO of(Optional<Group> group) {
        return of(group.orElse(Group.NULL));
    }
}
