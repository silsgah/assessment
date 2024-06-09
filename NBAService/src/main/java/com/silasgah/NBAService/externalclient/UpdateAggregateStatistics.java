package com.silasgah.NBAService.externalclient;



import com.silasgah.NBAService.model.AggregateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Aggregate-Service/aggregate")
public interface UpdateAggregateStatistics {
    @PostMapping("/PlayerAggregate")
    public ResponseEntity<Long> aggregate(AggregateRequest aggregateRequest);

    @PostMapping("/TeamAggregate")
    public ResponseEntity<Long> teamaggregate(AggregateRequest aggregateRequest);
}
