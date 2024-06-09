package com.silasgah.NBAService.controller;

import com.silasgah.NBAService.model.PlayerStatisticRequest;
import com.silasgah.NBAService.service.PlayerStatistics;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@Log4j2
public class PlayerController {
    @Autowired
    private PlayerStatistics playerStatistics;

    @PostMapping
    public ResponseEntity<Long> addPlayerStatistics(@RequestBody PlayerStatisticRequest playerStatisticRequest){
       long statisticId = playerStatistics.addStatistics(playerStatisticRequest);
       log.info("log created successfully");
       return new ResponseEntity<>(statisticId, HttpStatus.CREATED);
    }
}
