package com.silasgah.NBAService.externalclient.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silasgah.NBAService.externalclient.CustomException;
import com.silasgah.NBAService.model.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(),response.status());
        } catch (IOException e) {
            throw new CustomException("INTERNAL SERVER", "INTERNAL_ERROR", 500);
        }
    }
}
