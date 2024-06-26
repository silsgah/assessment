package com.silasgah.nbadatastatistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private int playerId;
    private int gameId;
    private int seasonId;
    private int teamId;
    private int Points;
    private int Rebounds;
    private int Assists;
    private int Steals;
    private int Blocks;
    private int TurnOvers;
    private int Fouls;
    private float Minute;
}
