package io.khosrow.fifawc.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.domain.User;

@RestController
public class UserApi {
    @GetMapping("/user")
    public User getUser(@AuthenticationPrincipal User user) {
        return user;
    }
}
