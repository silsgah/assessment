package com.silasgah.nbadatainjectionservice.exception;

import lombok.Data;

@Data
public class PlayerStatisticsCustomException extends RuntimeException{
    private String erroCode;

    public PlayerStatisticsCustomException(String message, String erroCode) {
        super(message);
        this.erroCode = erroCode;
    }
}
