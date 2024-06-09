package com.silasgah.NBAService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatisticResponse {
    private int Points;
    private int Rebounds;
    private int Assists;
    private int Steals;
    private int Blocks;
    private int TurnOvers;
    private int Fouls;
    private float Minute;
    private int gameId;
    private int playerId;
}
