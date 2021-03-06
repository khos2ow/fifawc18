package io.khosrow.fifawc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.GroupDTO;
import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.domain.Group;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.repo.GroupRepository;

@Service
public class GroupService {
    private final GroupRepository repository;
    private final StandingService standingService;
    private final MatchService matchService;

    @Autowired
    public GroupService(GroupRepository repository, StandingService standingService, MatchService matchService) {
        this.repository = repository;
        this.standingService = standingService;
        this.matchService = matchService;
    }

    /**
     * Find a Group by its UUID
     *
     * @param uuid to look for
     *
     * @return GroupDTO instance
     */
    public Optional<Group> getGroupByUuid(String uuid) {
        return repository.findByUuid(uuid);
    }

    /**
     * Find a Group by its name
     *
     * @param name to look for
     *
     * @return GroupDTO instance
     */
    public Optional<Group> getGroupByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Find a Group with Standing by its UUID
     *
     * @param uuid to look for
     *
     * @return GroupDTO instance
     */
    public GroupDTO getGroupWithStandingByUuid(String uuid) {
        return getGroupStanding(getGroupByUuid(uuid), null);
    }

    /**
     * Find a Group with Standing by its name
     *
     * @param name to look for
     *
     * @return GroupDTO instance
     */
    public GroupDTO getGroupWithStandingByName(String name) {
        return getGroupStanding(getGroupByName(name), null);
    }

    /**
     * Find all groups details
     *
     * @return list of GroupDTO
     */
    public List<GroupDTO> getAllGroups() {
        return repository.findAll()
                .stream()
                .map(g -> getGroupStanding(Optional.of(g), null))
                .collect(Collectors.toList());
    }

    /**
     * Find all groups details for User
     *
     * @param user to filter for
     *
     * @return list of GroupDTO
     */
    public List<GroupDTO> getAllGroups(User user) {
        return repository.findAll()
                .stream()
                .map(g -> getGroupStanding(Optional.of(g), user))
                .collect(Collectors.toList());
    }

    /**
     * Get list of matches in provided group
     *
     * @param uuid of Group to look up match for
     *
     * @return list of MatchDTO of current Group
     */
    public List<MatchDTO> getGroupMatchesByUuid(String uuid) {
        return matchService.getMatchesByGroup(getGroupByUuid(uuid));
    }

    /**
     * Get list of matches in provided group
     *
     * @param name of Group to look up match for
     *
     * @return list of MatchDTO of current Group
     */
    public List<MatchDTO> getGroupMatchesByName(String name) {
        return matchService.getMatchesByGroup(getGroupByName(name));
    }

    /**
     * Get group standings
     *
     * @param group instance
     *
     * @return GroupDTO instance with full standing list
     */
    private GroupDTO getGroupStanding(Optional<Group> group, User user) {
        final GroupDTO dto = GroupDTO.of(group);

        if (group.isPresent()) {
            dto.setStanding(standingService.getStandingByGroupId(group.get().getId(), user));
        }

        return dto;
    }
}
