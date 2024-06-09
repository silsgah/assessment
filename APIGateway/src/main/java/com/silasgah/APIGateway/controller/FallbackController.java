package com.silasgah.APIGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/playerServiceFallBack")
    public String playerServiceFallBack(){
        return "Play statistics server is down, we attending to this now";
    }

    @GetMapping("/aggregateServiceFallBack")
    public String aggregateServiceFallBack(){
        return "Aggregate statistics server is down, we attending to this now";
    }
}
