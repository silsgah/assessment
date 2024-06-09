package com.silasgah.nbadatastatistics.service;

import com.silasgah.nbadatastatistics.model.AggregateRequest;

import java.util.List;

public interface AggregateService {
    List<AggregateRequest> getAllPlayerStats();
    long playeraggregate(AggregateRequest aggregateRequest);
    long teamaggregate(AggregateRequest aggregateRequest);
}
