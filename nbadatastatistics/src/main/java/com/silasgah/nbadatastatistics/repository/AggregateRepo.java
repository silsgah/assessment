package com.silasgah.nbadatastatistics.repository;

import com.silasgah.nbadatastatistics.entity.PlayerAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AggregateRepo extends JpaRepository<PlayerAggregate, Long> {
    List<PlayerAggregate> findByPlayerIdAndGameIdAndSeasonId(int playerId, int gameId, int seasonId);
}
