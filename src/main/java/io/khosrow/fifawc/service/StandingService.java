package io.khosrow.fifawc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.StandingDTO;
import io.khosrow.fifawc.repo.StandingRepository;

@Service
public class StandingService {
    private final StandingRepository repository;

    @Autowired
    public StandingService(StandingRepository repository) {
        this.repository = repository;
    }

    /**
     * Get list of Standing teams in provided Group
     * 
     * @param id of group to look up standing for
     * 
     * @return list of StandingDTO
     */
    public List<StandingDTO> getStandingByGroupId(Integer id) {
        return repository.findByGroupId(id)
                .stream()
                .sorted()
                .map(StandingDTO::of)
                .collect(Collectors.toList());
    }
}
