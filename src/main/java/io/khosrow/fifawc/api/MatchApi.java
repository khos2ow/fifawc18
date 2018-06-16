package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.service.GroupService;
import io.khosrow.fifawc.service.MatchService;

@RestController
@RequestMapping("/api/matches")
public class MatchApi {
    private final MatchService service;
    private final GroupService groupService;

    @Autowired
    public MatchApi(MatchService service, GroupService groupService) {
        this.service = service;
        this.groupService = groupService;
    }

    @GetMapping(params = { "group" })
    public List<MatchDTO> getMatchesByGroup(@RequestParam(name = "group", required = true) String name) {
        return groupService.getGroupMatchesByName(name);
    }

    @GetMapping(params = { "stage" })
    public List<MatchDTO> getMatchesByStage(@RequestParam(name = "stage", required = true) String stage) {
        return service.getMatchesByStage(stage);
    }

    @GetMapping(params = { "sort" })
    public List<MatchDTO> getMatchesSorted(@RequestParam(name = "sort", required = true) String sort) {
        return service.getMatchesSorted(sort);
    }

    @PostMapping("/{id}")
    public MatchDTO saveMatchResult(@PathVariable(value = "id") String uuid, @RequestBody MatchDTO payload) {
        return service.saveMatchResult(uuid, payload);
    }

    @PostMapping("/home/{home}/away/{away}")
    public MatchDTO saveMatchResult(@PathVariable(value = "home") String homeUuid, @PathVariable(value = "away") String awayUuid, @RequestBody MatchDTO payload) {

        return service.saveMatchResult(homeUuid, awayUuid, payload);
    }
}
