package io.khosrow.fifawc.api;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/predictions")
public class PredictApi {
    @GetMapping("/{id}")
    public String saveMatchResult(@PathVariable(value = "id") String uuid, Principal principal) {
        return "prediction of " + uuid + " from user: " + principal.getName();
    }
}
