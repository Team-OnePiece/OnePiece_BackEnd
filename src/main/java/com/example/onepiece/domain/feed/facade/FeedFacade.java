package com.example.onepiece.domain.feed.facade;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.domain.repository.FeedRepository;
import com.example.onepiece.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeed(Long feedId) {
        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
