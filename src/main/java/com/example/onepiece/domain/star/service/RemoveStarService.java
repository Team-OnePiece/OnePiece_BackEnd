package com.example.onepiece.domain.star.service;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.facade.FeedFacade;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.star.exception.RemoveStarExistException;
import com.example.onepiece.domain.star.facade.StarFacade;
import com.example.onepiece.domain.star.presentation.dto.response.StarResponse;
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
    public StarResponse deleteStar(Long boardId) {
        User user = userFacade.getCurrentUser();
        Feed board = boardFacade.getBoard(boardId);

        if (!starFacade.hasUserGivenStarToBoard(user, board)) {
            throw RemoveStarExistException.EXCEPTION;
        }

        board.minusStarCount();
        return removeStar(user, board);
    }

    private StarResponse removeStar(User user, Feed board) {
        starRepository.deleteByUserAndBoard(user, board);

        return new StarResponse(board.getStarCounts(),
                starFacade.hasUserGivenStarToBoard(user, board));
    }
}
