package io.khosrow.fifawc.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.domain.Group;
import io.khosrow.fifawc.repo.MatchRepository;

@Service
public class MatchService {
    private final MatchRepository repository;

    @Autowired
    public MatchService(MatchRepository repository) {
        this.repository = repository;
    }

    /**
     * Get list of matches in provided group
     * 
     * @param group instance look up match for
     * 
     * @return list of MatchDTO of current Group
     */
    public List<MatchDTO> getMatchesByGroup(Optional<Group> group) {
        if (!group.isPresent()) {
            return Collections.emptyList();
        }

        return repository.findByGroupId(group.get().getId())
                .stream()
                .map(MatchDTO::of)
                .collect(Collectors.toList());
    }
}
