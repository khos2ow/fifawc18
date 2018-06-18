package io.khosrow.fifawc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamsController {
    @RequestMapping("/teams")
    public String teams() {
        return "teams.html";
    }
}
