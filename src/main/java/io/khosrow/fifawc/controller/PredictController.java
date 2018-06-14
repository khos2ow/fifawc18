package io.khosrow.fifawc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PredictController {
    @RequestMapping("/predict")
    public String predict() {
        return "predict.html";
    }
}
