package com.example.onepiece.domain.star.service;


import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.facade.FeedFacade;
import com.example.onepiece.domain.star.domain.Star;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.star.exception.StarExistException;
import com.example.onepiece.domain.star.facade.StarFacade;
import com.example.onepiece.domain.star.presentation.dto.response.StarResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateStarService {

    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final FeedFacade boardFacade;
    private final StarFacade starFacade;

    @Transactional
    public StarResponse createStar(Long feedId) {
        User user = userFacade.getCurrentUser();
        Feed board = boardFacade.getBoard(feedId);

        if (starFacade.hasUserGivenStarToBoard(user, board)) {
            throw StarExistException.EXCEPTION;
        }

        board.addStarCount();
        return addStar(user, board);
    }

    private StarResponse addStar(User user, Feed feed) {
        starRepository.save(Star.builder()
            .user(user)
            .board(feed)
            .build());

        return new StarResponse(feed.getStarCounts(),
            starFacade.hasUserGivenStarToBoard(user, feed));
    }
}
