package com.silasgah.nbadatainjectionservice.controller;

import com.silasgah.nbadatainjectionservice.model.PlayerStatisticRequest;
import com.silasgah.nbadatainjectionservice.service.PlayerStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerStatistics playerStatistics;

    @PostMapping
    public ResponseEntity<Long> addPlayerStatistics(@RequestBody PlayerStatisticRequest playerStatisticRequest){
        long statisticId = playerStatistics.addStatistics(playerStatisticRequest);
        return new ResponseEntity<>(statisticId, HttpStatus.CREATED);
    }
}
