package com.example.onepiece.domain.star.service;


import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.facade.FeedFacade;
import com.example.onepiece.domain.star.domain.Star;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.star.exception.StarExistException;
import com.example.onepiece.domain.star.facade.StarFacade;
import com.example.onepiece.domain.star.presentation.dto.StarResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateStarService {

    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final StarFacade starFacade;

    @Transactional
    public StarResponse createStar(Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getBoard(feedId);

        if (starFacade.hasUserGivenStarToBoard(user, feed)) {
            throw StarExistException.EXCEPTION;
        }

        feed.addStarCount();
        return addStar(user, feed);
    }

    private StarResponse addStar(User user, Feed feed) {
        starRepository.save(Star.builder()
                .user(user)
                .feed(feed)
                .build());

        return StarResponse.builder()
                .starCount(feed.getStarCounts())
                .build();
    }
}
