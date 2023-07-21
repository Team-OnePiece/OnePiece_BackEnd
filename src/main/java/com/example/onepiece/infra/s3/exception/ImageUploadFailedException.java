package com.example.onepiece.infra.s3.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class ImageUploadFailedException extends CustomException {

    public static final CustomException EXCEPTION =
            new ImageUploadFailedException();

    private ImageUploadFailedException() {
        super(ErrorCode.IMAGE_UPLOAD_FAILED);
    }
}
