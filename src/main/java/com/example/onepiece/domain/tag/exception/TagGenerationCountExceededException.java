package com.example.onepiece.domain.tag.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class TagGenerationCountExceededException extends CustomException {

    public static final CustomException EXCEPTION = new TagGenerationCountExceededException();

    private TagGenerationCountExceededException(){
        super(ErrorCode.TAG_GENERATION_COUNT_EXCEEDED);
    }
}
