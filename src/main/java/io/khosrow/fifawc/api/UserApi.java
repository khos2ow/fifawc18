package io.khosrow.fifawc.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.service.PredictionService;
import io.khosrow.fifawc.service.UserService;

@RestController
public class UserApi {
    private final UserService service;
    private final PredictionService predictionService;

    public UserApi(UserService service, PredictionService predictionService) {
        this.service = service;
        this.predictionService = predictionService;
    }

    @GetMapping("/user")
    public User getUser(@AuthenticationPrincipal User user) {
        User entity = service.getUserByPrincipalId(user.getPrincipalId());

        predictionService.generatePredictionForNewUser(entity);

        return user;
    }
}
