package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.TeamDTO;
import io.khosrow.fifawc.service.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamApi {
    private final TeamService service;

    @Autowired
    public TeamApi(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeamDTO> getAllTeams(@RequestParam(name = "sort", required = false) String sort) {
        return service.getAllTeams(sort);
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamByUuid(@PathVariable(value = "id") String uuid) {
        return service.getTeamDtoById(uuid);
    }
}
