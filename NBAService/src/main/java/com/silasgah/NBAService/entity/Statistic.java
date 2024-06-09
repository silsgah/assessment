package com.silasgah.NBAService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Statistic {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long Id;
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
