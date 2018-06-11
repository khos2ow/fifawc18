package io.khosrow.fifawc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.service.MatchService;

@RestController
@RequestMapping("/api/matches")
public class MatchApi {
    private final MatchService service;

    @Autowired
    public MatchApi(MatchService service) {
        this.service = service;
    }
}
