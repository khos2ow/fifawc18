package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.MatchDTO;
import io.khosrow.fifawc.service.MatchService;

@RestController
@RequestMapping("/api/matches")
public class MatchApi {
    private final MatchService service;

    @Autowired
    public MatchApi(MatchService service) {
        this.service = service;
    }

//    @GetMapping(params = {"group"})
//    public List<MatchDTO> getMatchesByGroup(@RequestParam(name = "group", required = true) String group) {
//        return service.getGroupByName(group);
//    }

    @GetMapping(params = {"stage"})
    public List<MatchDTO> getMatchesByStage(@RequestParam(name = "stage", required = true) String stage) {
        return service.getMatchesByStage(stage);
    }
}
