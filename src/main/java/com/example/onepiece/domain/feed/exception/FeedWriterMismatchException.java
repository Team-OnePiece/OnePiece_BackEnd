package com.example.onepiece.domain.feed.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class FeedWriterMismatchException extends CustomException {

    public static final CustomException EXCEPTION = new FeedWriterMismatchException();

    public FeedWriterMismatchException() {
        super(ErrorCode.FEED_WRITER_MISMATCH);
    }
}
