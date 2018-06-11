package io.khosrow.fifawc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.GroupDTO;
import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.domain.Group;
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
    public GroupDTO getGroupByUuid(String uuid) {
        return getGroupStanding(repository.findByUuid(uuid));
    }

    /**
     * Find a Group by its name
     * 
     * @param name to look for
     * 
     * @return GroupDTO instance
     */
    public GroupDTO getGroupByName(String name) {
        return getGroupStanding(repository.findByName(name));
    }

    /**
     * Find all groups details
     * 
     * @return list of GroupDTO
     */
    public List<GroupDTO> getAllGroups() {
        return repository.findAll()
                .stream()
                .map(g -> getGroupStanding(Optional.of(g)))
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
        return matchService.getMatchesByGroup(repository.findByUuid(uuid));
    }

    /**
     * Get group standings
     * 
     * @param group instance
     * 
     * @return GroupDTO instance with full standing list
     */
    private GroupDTO getGroupStanding(Optional<Group> group) {
        final GroupDTO dto = GroupDTO.of(group);

        if (group.isPresent()) {
            dto.setStanding(standingService.getStandingByGroupId(group.get().getId()));
        }

        return dto;
    }
}
