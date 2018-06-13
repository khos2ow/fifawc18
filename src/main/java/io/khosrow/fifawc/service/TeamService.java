package io.khosrow.fifawc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import io.khosrow.fifawc.common.dto.TeamDTO;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.repo.TeamRepository;

@Service
public class TeamService {
    private final TeamRepository repository;

    @Autowired
    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    /**
     * Find a Team by its UUID
     * 
     * @param uuid to look for
     * 
     * @return TeamDTO instance
     */
    public Optional<Team> getTeamById(String uuid) {
        return repository.findByUuid(uuid);
    }

    /**
     * Find a Team by its UUID
     * 
     * @param uuid to look for
     * 
     * @return TeamDTO instance
     */
    public TeamDTO getTeamDtoById(String uuid) {
        return TeamDTO.of(getTeamById(uuid));
    }

    /**
     * Find all teams
     * 
     * @param sort 
     * 
     * @return list of TeamDTO
     */
    public List<TeamDTO> getAllTeams(final String sort) {
        return repository.findAll()
                .stream()
                .sorted((t1, t2) -> {
                    if (!Strings.isNullOrEmpty(sort)) {
                        if (sort.equals("name")) {
                            return t1.getCountry().getName().compareTo(t2.getCountry().getName());
                        } else if (sort.equals("iso2")) {
                            return t1.getCountry().getIso2().compareTo(t2.getCountry().getIso2());
                        } else if (sort.equals("iso3")) {
                            return t1.getCountry().getIso3().compareTo(t2.getCountry().getIso3());
                        } else if (sort.equals("rank")) {
                            return t1.getFifaRank().compareTo(t2.getFifaRank());
                        } else {
                            return t1.getId().compareTo(t2.getId());
                        }
                    } else {
                        return t1.getId().compareTo(t2.getId());
                    }
                })
                .map(TeamDTO::of)
                .collect(Collectors.toList());
    }
}
