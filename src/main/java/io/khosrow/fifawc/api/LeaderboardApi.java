package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.UserDTO;
import io.khosrow.fifawc.service.UserService;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardApi {
    private final UserService service;

    @Autowired
    public LeaderboardApi(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getLeaderboards() {
        return service.getLeaderboard();
    }
}
