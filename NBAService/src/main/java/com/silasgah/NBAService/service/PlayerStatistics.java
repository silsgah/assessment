package com.silasgah.NBAService.service;

import com.silasgah.NBAService.model.PlayerStatisticRequest;
import com.silasgah.NBAService.model.PlayerStatisticResponse;

public interface PlayerStatistics {
    long addStatistics(PlayerStatisticRequest playerStatisticRequest);
}
