package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.GroupDTO;
import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.common.dto.PredictionDTO;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.service.GroupService;
import io.khosrow.fifawc.service.PredictionService;
import io.khosrow.fifawc.service.UserService;

@RestController
@RequestMapping("/api/predictions")
public class PredictApi {
    private final PredictionService service;
    private final UserService userService;
    private final GroupService groupService;

    @Autowired
    public PredictApi(PredictionService service, UserService userService, GroupService groupService) {
        this.service = service;
        this.userService = userService;
        this.groupService = groupService;
    }

    @GetMapping
    public List<PredictionDTO> getMatchPredictions(@AuthenticationPrincipal User user) {
        return service.getPredictionsOfUser(user);
    }

    @GetMapping("/groups")
    public List<GroupDTO> getAllGroups(@AuthenticationPrincipal User user) {
        User entity = userService.getUserByPrincipalId(user.getPrincipalId());

        return groupService.getAllGroups(entity);
    }

    @GetMapping("/groups/{id}/matches")
    public List<MatchDTO> getGroupMatchesByUuid(@PathVariable(value = "id") String uuid, @AuthenticationPrincipal User user) {
        return groupService.getGroupMatchesByUuid(uuid);
    }

    @GetMapping(value = "/matches", params = {"stage"})
    public List<MatchDTO> getMatchesByStage(@RequestParam(name = "stage", required = true) String stage, @AuthenticationPrincipal User user) {
        User entity = userService.getUserByPrincipalId(user.getPrincipalId());

        return service.getMatchesByStage(stage, entity);
    }

    @PostMapping
    public boolean saveMatchPredictions(@RequestBody List<PredictionDTO> payload, @AuthenticationPrincipal User user) {
        User entity = userService.getUserByPrincipalId(user.getPrincipalId());

        return service.savePredictionsOfUser(payload, entity);
    }
}
