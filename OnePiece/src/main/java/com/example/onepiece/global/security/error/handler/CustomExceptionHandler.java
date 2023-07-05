package com.example.onepiece.global.security.error.handler;

import com.example.onepiece.global.security.error.entity.ErrorResponseEntity;
import com.example.onepiece.global.security.error.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException customException){
        return ErrorResponseEntity.responseEntity(customException.getErrorCode());
    }
}
