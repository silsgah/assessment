package com.silasgah.AggregateService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamAggregateRequest {
    private int playerId;
    private int gameId;
    private int teamId;
    private int seasonId;
    private int Points;
    private int Rebounds;
    private int Assists;
    private int Steals;
    private int Blocks;
    private int TurnOvers;
    private int Fouls;
    private float Minute;
}
