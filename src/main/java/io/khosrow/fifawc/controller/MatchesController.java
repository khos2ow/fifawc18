package io.khosrow.fifawc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatchesController {
    @RequestMapping("/matches")
    public String matches() {
        return "matches.html";
    }
}
