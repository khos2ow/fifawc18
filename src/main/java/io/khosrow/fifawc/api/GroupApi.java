package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.GroupDTO;
import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.service.GroupService;

@RestController
@RequestMapping("/api/groups")
public class GroupApi {
    private final GroupService service;

    @Autowired
    public GroupApi(GroupService service) {
        this.service = service;
    }

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return service.getAllGroups();
    }

    @GetMapping(params = {"name"})
    public GroupDTO getGroupByName(@RequestParam(name = "name", required = true) String name) {
        return service.getGroupWithStandingByName(name);
    }

    @GetMapping("/{id}")
    public GroupDTO getGroupByUuid(@PathVariable(value = "id") String uuid) {
        return service.getGroupWithStandingByUuid(uuid);
    }

    @GetMapping("/{id}/matches")
    public List<MatchDTO> getGroupMatchesByUuid(@PathVariable(value = "id") String uuid) {
        return service.getGroupMatchesByUuid(uuid);
    }
}
