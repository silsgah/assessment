package com.silasgah.nbadatainjectionservice.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PlayerStatisticRequest {
    private int Points;
    private int Rebounds;
    private int Assists;
    private int Steals;
    private int Blocks;
    private int TurnOvers;
    @Min(value = 0, message = "Fouls must be a non-negative integer")
    @Max(value = 6, message = "Fouls cannot exceed 6")
    private int Fouls;
    @DecimalMin(value = "0.0", inclusive = true, message = "Minutes played must be at least 0.0")
    @DecimalMax(value = "48.0", inclusive = true, message = "Minutes played cannot exceed 48.0")
    private float Minute;
    private int gameId;
    private int playerId;
    private int teamId;
    private int seasonId;
}
