package com.silasgah.nbadatastatistics.repository;

import com.silasgah.nbadatastatistics.entity.TeamAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamAggregateRepo extends JpaRepository<TeamAggregate, Long> {
    List<TeamAggregate> findByTeamIdAndGameIdAndSeasonId(int playerId, int gameId, int seasonId);
}

