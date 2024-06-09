package com.silasgah.nbadatastatistics.service;


import com.silasgah.nbadatastatistics.entity.PlayerAggregate;
import com.silasgah.nbadatastatistics.entity.TeamAggregate;
import com.silasgah.nbadatastatistics.model.AggregateRequest;
import com.silasgah.nbadatastatistics.repository.AggregateRepo;
import com.silasgah.nbadatastatistics.repository.TeamAggregateRepo;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AggregateServiceImpl implements AggregateService{

    @Autowired
    private AggregateRepo aggregateRepo;

    @Autowired
    private TeamAggregateRepo teamAggregateRepo;

    @Override
    public List<AggregateRequest> getAllPlayerStats() {
        List<PlayerAggregate> allPlayerAggregates = aggregateRepo.findAll();
        List<AggregateRequest> aggregateRequests = allPlayerAggregates.stream()
                .map(aggregate -> new AggregateRequest(
                        aggregate.getPlayerId(),
                        aggregate.getGameId(),
                        aggregate.getTeamId(),
                        aggregate.getSeasonId(),
                        aggregate.getFouls(),
                        aggregate.getTurnOvers(),
                        aggregate.getBlocks(),
                        aggregate.getSteals(),
                        aggregate.getAssists(),
                        aggregate.getPoints(),
                        aggregate.getRebounds(),
                        aggregate.getMinute()
                ))
                .collect(Collectors.toList());
        return aggregateRequests;
    }
    @Override
    public long playeraggregate(AggregateRequest aggregateRequest) {
        List<PlayerAggregate> stats = aggregateRepo.findByPlayerIdAndGameIdAndSeasonId(aggregateRequest.getPlayerId(), aggregateRequest.getGameId(), aggregateRequest.getSeasonId());
        if (stats.isEmpty()) {
            PlayerAggregate firstAggregate = PlayerAggregate.builder()
                    .Fouls(aggregateRequest.getFouls())
                    .Assists(aggregateRequest.getAssists())
                    .Blocks(aggregateRequest.getBlocks())
                    .Minute(aggregateRequest.getMinute())
                    .Points(aggregateRequest.getPoints())
                    .Rebounds(aggregateRequest.getRebounds())
                    .Steals(aggregateRequest.getSteals())
                    .TurnOvers(aggregateRequest.getTurnOvers())
                    .gameId(aggregateRequest.getGameId())
                    .playerId(aggregateRequest.getPlayerId())
                    .teamId(aggregateRequest.getTeamId())
                    .seasonId(aggregateRequest.getSeasonId())
                    .build();
            aggregateRepo.save(firstAggregate);
            return 0; // No stats found
        } else {
            int totalPoints = aggregateRequest.getPoints();
            int totalRebounds = aggregateRequest.getRebounds();
            int totalAssist = aggregateRequest.getAssists();
            int totalSteals = aggregateRequest.getSteals();
            int totalBlocks = aggregateRequest.getBlocks();
            int totalTurnOvers = aggregateRequest.getTurnOvers();
            int totalFouls = aggregateRequest.getFouls();
            float totalMinute = aggregateRequest.getMinute();
            for (PlayerAggregate stat : stats) {
                totalPoints += stat.getPoints();
                totalRebounds += stat.getRebounds();
                totalAssist += stat.getAssists();
                totalSteals += stat.getSteals();
                PlayerAggregate aggregate = aggregateRepo.findById(stat.getId())
                        .orElseThrow(() -> new NotFoundException("Aggregate not found for ID: " + stat.getId()));
                aggregate.setPoints(totalPoints / stats.size());
                aggregate.setRebounds(totalRebounds / stats.size());
                aggregate.setAssists(totalAssist / stats.size());
                aggregate.setSteals(totalSteals / stats.size());
                aggregate.setBlocks(totalBlocks / stats.size());
                aggregate.setTurnOvers(totalTurnOvers / stats.size());
                aggregate.setFouls(totalFouls / stats.size());
                aggregate.setMinute(totalMinute/stats.size());
                aggregateRepo.save(aggregate);
            }
            return 1;
        }
    }

    @Override
    public long teamaggregate(AggregateRequest aggregateRequest) {
        List<TeamAggregate> stats = teamAggregateRepo.findByTeamIdAndGameIdAndSeasonId(aggregateRequest.getTeamId(), aggregateRequest.getGameId(), aggregateRequest.getSeasonId());
        if (stats.isEmpty()) {
            TeamAggregate firstAggregate = TeamAggregate.builder()
                    .Fouls(aggregateRequest.getFouls())
                    .Assists(aggregateRequest.getAssists())
                    .Blocks(aggregateRequest.getBlocks())
                    .Minute(aggregateRequest.getMinute())
                    .Points(aggregateRequest.getPoints())
                    .Rebounds(aggregateRequest.getRebounds())
                    .Steals(aggregateRequest.getSteals())
                    .TurnOvers(aggregateRequest.getTurnOvers())
                    .gameId(aggregateRequest.getGameId())
                    .playerId(aggregateRequest.getPlayerId())
                    .teamId(aggregateRequest.getTeamId())
                    .seasonId(aggregateRequest.getSeasonId())
                    .build();
            teamAggregateRepo.save(firstAggregate);
            return 0; // No stats found
        } else {
            int totalPoints = aggregateRequest.getPoints();
            int totalRebounds = aggregateRequest.getRebounds();
            int totalAssist = aggregateRequest.getAssists();
            int totalSteals = aggregateRequest.getSteals();
            int totalBlocks = aggregateRequest.getBlocks();
            int totalTurnOvers = aggregateRequest.getTurnOvers();
            int totalFouls = aggregateRequest.getFouls();
            float totalMinute = aggregateRequest.getMinute();
            for (TeamAggregate stat : stats) {
                totalPoints += stat.getPoints();
                totalRebounds += stat.getRebounds();
                totalAssist += stat.getAssists();
                totalSteals += stat.getSteals();
                TeamAggregate aggregate = teamAggregateRepo.findById(stat.getId())
                        .orElseThrow(() -> new NotFoundException("Aggregate not found for ID: " + stat.getId()));
                aggregate.setPoints(totalPoints / stats.size());
                aggregate.setRebounds(totalRebounds / stats.size());
                aggregate.setAssists(totalAssist / stats.size());
                aggregate.setSteals(totalSteals / stats.size());
                aggregate.setBlocks(totalBlocks / stats.size());
                aggregate.setTurnOvers(totalTurnOvers / stats.size());
                aggregate.setFouls(totalFouls / stats.size());
                aggregate.setMinute(totalMinute/stats.size());
                teamAggregateRepo.save(aggregate);
            }
            return 1;
        }
    }
}

