package com.silasgah.AggregateService.service;

import com.silasgah.AggregateService.model.AggregateRequest;

import java.util.List;

public interface AggregateService {
    List<AggregateRequest> getAllPlayerStats();
    long playeraggregate(AggregateRequest aggregateRequest);
    long teamaggregate(AggregateRequest aggregateRequest);
}
