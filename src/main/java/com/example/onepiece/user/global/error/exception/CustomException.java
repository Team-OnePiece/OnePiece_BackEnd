package com.example.onepiece.user.global.error.exception;

import com.example.onepiece.user.global.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private ErrorCode errorCode;
}