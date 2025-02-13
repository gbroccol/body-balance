package org.body.balance.recipe.exception;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.body.balance.recipe.config.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<ErrorResponse>> exception(Exception e) {
        return new ResponseEntity<>(List.of(new ErrorResponse("Internal server error.", e.getMessage(), null)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SendDataToKafkaException.class)
    @ApiResponse(responseCode = "500", description = "sendDataToKafkaException")
    public ResponseEntity<List<ErrorResponse>> sendDataToKafkaException(SendDataToKafkaException e) {
        return new ResponseEntity<>(List.of(new ErrorResponse("Can not send data to Kafka.", e.getMessage(), null)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
