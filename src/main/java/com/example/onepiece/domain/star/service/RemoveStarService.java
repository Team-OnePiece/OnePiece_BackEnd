package com.example.onepiece.domain.star.service;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.facade.FeedFacade;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.star.exception.RemoveStarExistException;
import com.example.onepiece.domain.star.facade.StarFacade;
import com.example.onepiece.domain.star.presentation.dto.StarResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RemoveStarService {

    private final UserFacade userFacade;
    private final FeedFacade boardFacade;
    private final StarFacade starFacade;
    private final StarRepository starRepository;

    @Transactional
    public StarResponse deleteStar(Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = boardFacade.getFeed(feedId);

        if (!starFacade.hasUserGivenStarToBoard(user, feed)) {
            throw RemoveStarExistException.EXCEPTION;
        }

        starRepository.deleteByUserAndFeed(user, feed);

        feed.minusStarCount();

        return new StarResponse(feed.getStarCounts());
    }
}
