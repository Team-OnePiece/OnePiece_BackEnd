package com.example.onepiece.domain.feed.service;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.domain.repository.FeedRepository;
import com.example.onepiece.domain.feed.exception.FeedWriterMismatchException;
import com.example.onepiece.domain.feed.facade.FeedFacade;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteFeedService {

    private final FeedFacade feedFacade;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void deleteFeed(Long feedId) {
        User currentUser = userFacade.getCurrentUser();
        Feed board = feedFacade.getFeed(feedId);

        if (!currentUser.equals(board.getUser())) {
            throw FeedWriterMismatchException.EXCEPTION;
        }
        
        feedRepository.deleteById(feedId);
    }
}
