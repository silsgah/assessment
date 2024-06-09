package com.silasgah.nbadatainjectionservice.service;

import com.silasgah.nbadatainjectionservice.entity.Statistic;
import com.silasgah.nbadatainjectionservice.exception.PlayerStatisticsCustomException;
import com.silasgah.nbadatainjectionservice.model.AggregateRequest;
import com.silasgah.nbadatainjectionservice.model.PlayerStatisticRequest;
import com.silasgah.nbadatainjectionservice.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatisticsImpl implements PlayerStatistics{
    @Autowired
    private PlayerRepo playerRepo;
//    @Autowired
//    private UpdateAggregateStatistics updateAggregateStatistics;
    @Override
    public long addStatistics(PlayerStatisticRequest playerStatisticRequest) {
        if(playerStatisticRequest.getFouls() > 6){
            throw new PlayerStatisticsCustomException("Fouls must not be greater than value 6", "FOUL_GREATER_SIX");
        }
        if(playerStatisticRequest.getMinute() > 48 || playerStatisticRequest.getMinute() < 0){
            throw new PlayerStatisticsCustomException("Minutes must be between 0 and 48", "MINUTES_PLAYED");
        }
        Statistic statistic = Statistic.builder()
                .Fouls(playerStatisticRequest.getFouls())
                .Assists(playerStatisticRequest.getAssists())
                .Blocks(playerStatisticRequest.getBlocks())
                .Minute(playerStatisticRequest.getMinute())
                .Points(playerStatisticRequest.getPoints())
                .Rebounds(playerStatisticRequest.getRebounds())
                .Steals(playerStatisticRequest.getSteals())
                .TurnOvers(playerStatisticRequest.getTurnOvers())
                .gameId(playerStatisticRequest.getGameId())
                .playerId(playerStatisticRequest.getPlayerId())
                .teamId(playerStatisticRequest.getTeamId())
                .seasonId(playerStatisticRequest.getSeasonId())
                .build();
        playerRepo.save(statistic);
        AggregateRequest aggregateRequest = AggregateRequest.builder()
                .Fouls(playerStatisticRequest.getFouls())
                .Assists(playerStatisticRequest.getAssists())
                .Blocks(playerStatisticRequest.getBlocks())
                .Minute(playerStatisticRequest.getMinute())
                .Points(playerStatisticRequest.getPoints())
                .Rebounds(playerStatisticRequest.getRebounds())
                .Steals(playerStatisticRequest.getSteals())
                .TurnOvers(playerStatisticRequest.getTurnOvers())
                .gameId(playerStatisticRequest.getGameId())
                .playerId(playerStatisticRequest.getPlayerId())
                .teamId(playerStatisticRequest.getTeamId())
                .seasonId(playerStatisticRequest.getSeasonId())
                .build();
//        updateAggregateStatistics.aggregate(aggregateRequest);
//        updateAggregateStatistics.teamaggregate(aggregateRequest);
        return statistic.getId();
    }

}
