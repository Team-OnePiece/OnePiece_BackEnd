package com.example.onepiece.infra.s3;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class ImageNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new ImageNotFoundException();

    private ImageNotFoundException(){
        super(ErrorCode.IMAGE_NOT_FOUND);
    }
}
