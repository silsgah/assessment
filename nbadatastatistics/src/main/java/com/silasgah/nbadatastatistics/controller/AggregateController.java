package com.silasgah.nbadatastatistics.controller;

import com.silasgah.nbadatastatistics.model.AggregateRequest;
import com.silasgah.nbadatastatistics.service.AggregateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aggregate")
public class AggregateController {
    @Autowired
    private AggregateService aggregateService;

    @GetMapping("/teamStats")
    public List<AggregateRequest> teamStats()
    {
        List<AggregateRequest> teamStats = aggregateService.getAllPlayerStats();
        return teamStats;
    }
    @GetMapping("/playerStats")
    public List<AggregateRequest> playerStats()
    {
        List<AggregateRequest> playerStats = aggregateService.getAllPlayerStats();
        return playerStats;
    }
    @PostMapping("/PlayerAggregate")
    public ResponseEntity<Long> aggregate(@RequestBody AggregateRequest aggregateRequest){
        long aggregateId = aggregateService.playeraggregate(aggregateRequest);
        return new ResponseEntity<>(aggregateId, HttpStatus.OK);
    }
    @PostMapping("/TeamAggregate")
    public ResponseEntity<Long> teamaggregate(@RequestBody AggregateRequest aggregateRequest){
        long aggregateId = aggregateService.teamaggregate(aggregateRequest);
        return new ResponseEntity<>(aggregateId, HttpStatus.OK);
    }
}
