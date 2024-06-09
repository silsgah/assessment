package com.silasgah.nbadatainjectionservice.externalclient.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silasgah.nbadatainjectionservice.externalclient.CustomException;
import com.silasgah.nbadatainjectionservice.model.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

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
