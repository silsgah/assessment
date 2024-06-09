package com.silasgah.AggregateService.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    private String erroCode;
    private int status;

    public CustomException(String message,String erroCode, int status) {
        super(message);
        this.erroCode = erroCode;
        this.status = status;
    }
}
