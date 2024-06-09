package com.silasgah.nbadatainjectionservice.service;

import com.silasgah.nbadatainjectionservice.model.PlayerStatisticRequest;

public interface PlayerStatistics {
    long addStatistics(PlayerStatisticRequest playerStatisticRequest);
}