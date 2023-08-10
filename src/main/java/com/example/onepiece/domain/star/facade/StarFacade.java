package com.example.onepiece.domain.star.facade;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.star.domain.repository.UnStarRepository;
import com.example.onepiece.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StarFacade {

    private final StarRepository starRepository;
    private final UnStarRepository unStarRepository;

    public boolean checkStar(User user, Board board) {
        return starRepository.existsByUserAndBoard(user, board);
    }

    public boolean checkUnStar(User user, Board board) {
        return unStarRepository.existsByUserAndBoard(user, board);
    }
}
