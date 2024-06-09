package com.silasgah.NBAService.exception;

import com.silasgah.NBAService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlayerStatisticsCustomException.class)
    public ResponseEntity<ErrorResponse> handleStatisticsException(PlayerStatisticsCustomException exception){
         return new ResponseEntity<>(new ErrorResponse().builder()
                 .errorMessage(exception.getMessage())
                 .errorCode(exception.getErroCode())
                 .build(), HttpStatus.NOT_FOUND);
    }
}
