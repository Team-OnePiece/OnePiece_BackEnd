package com.example.onepiece.domain.star.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.facade.BoardFacade;
import com.example.onepiece.domain.star.domain.Star;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.star.exception.RemoveStarExistException;
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
public class StarService {

    private final StarRepository starRepository;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final StarFacade starFacade;

    @Transactional
    public StarResponse createStar(Long boardId) {
        User user = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if (starFacade.hasUserGivenStarToBoard(user, board)) {
            throw StarExistException.EXCEPTION;
        }

        board.addStarCount();
        return addStar(user, board);
    }

    @Transactional
    public StarResponse deleteStar(Long boardId) {
        User user = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if (!starFacade.hasUserGivenStarToBoard(user, board)) {
            throw RemoveStarExistException.EXCEPTION;
        }

        board.minusStarCount();
        return removeStar(user, board);
    }

    private StarResponse addStar(User user, Board board) {
        starRepository.save(Star.builder()
            .user(user)
            .board(board)
            .build());

        return new StarResponse(board.getStarCounts(),
            starFacade.hasUserGivenStarToBoard(user, board));
    }

    private StarResponse removeStar(User user, Board board) {
        starRepository.deleteByUserAndBoard(user, board);

        return new StarResponse(board.getStarCounts(),
            starFacade.hasUserGivenStarToBoard(user, board));
    }
}

