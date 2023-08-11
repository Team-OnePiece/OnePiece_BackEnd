package com.example.onepiece.domain.star.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.facade.BoardFacade;
import com.example.onepiece.domain.star.domain.Star;
import com.example.onepiece.domain.star.domain.repository.UnStarRepository;
import com.example.onepiece.domain.star.exception.UnStarExistException;
import com.example.onepiece.domain.star.facade.StarFacade;
import com.example.onepiece.domain.star.presentation.dto.response.UnStarResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UnStarService {

    private final UnStarRepository unStarRepository;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final StarFacade starFacade;

    @Transactional
    public UnStarResponse unStar(Long boardId) {
        User user = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if (starFacade.checkUnStar(user, board)) {
            throw UnStarExistException.EXCEPTION;
        }

        board.addUnStarCount();
        return addUnStar(user, board);
    }

    @Transactional
    public UnStarResponse deleteUnStar(Long boardId) {
        User user = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if(!starFacade.checkUnStar(user,board)){
            throw UnStarExistException.EXCEPTION;
        }

        board.minusUnStarCount();
        return removeUnStar(user,board);
    }

    private UnStarResponse addUnStar(User user, Board board) {
        unStarRepository.save(Star.builder()
            .user(user)
            .board(board)
            .build());

        return UnStarResponse.builder()
            .unStarCounts(board.getUnStarCounts())
            .unStar(starFacade.checkUnStar(user, board))
            .build();
    }

    private UnStarResponse removeUnStar(User user, Board board) {
        unStarRepository.deleteByUserAndBoard(user, board);

        return UnStarResponse.builder()
            .unStarCounts(board.getUnStarCounts())
            .unStar(starFacade.checkUnStar(user, board))
            .build();
    }
}
