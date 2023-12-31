package com.example.onepiece.global.error.handler;

import com.example.onepiece.global.error.entity.ErrorResponseEntity;
import com.example.onepiece.global.error.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException customException) {

        return ErrorResponseEntity.responseEntity(customException.getErrorCode());
    }
}
