package com.algaworks.algalog.domain.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> handleCustomException(APIException exceptionToHandle){
        return new ResponseEntity<>(exceptionToHandle.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
