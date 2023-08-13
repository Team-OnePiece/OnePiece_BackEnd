package com.example.onepiece.domain.board.service;

import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.exception.BoardWriterMismatchException;
import com.example.onepiece.domain.board.facade.BoardFacade;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BoardModifyService {

    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    @Transactional
    public void modifyBoard(Long boardId, String place, MultipartFile boardImage) {

        User currentUser = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        if (!currentUser.equals(board.getUser())) {
            throw BoardWriterMismatchException.EXCEPTION;
        }

        String boardImageUrl = s3Facade.uploadImage(boardImage);
        board.modifyPlaceAndBoardImageUrl(place, boardImageUrl);
    }
}
