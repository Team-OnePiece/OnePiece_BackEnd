package com.example.onepiece.global.error.exception;

import com.example.onepiece.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;

}
