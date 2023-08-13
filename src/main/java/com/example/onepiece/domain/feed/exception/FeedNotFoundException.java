package com.example.onepiece.domain.feed.exception;

import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;

public class FeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new FeedNotFoundException();

    public FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }
}
