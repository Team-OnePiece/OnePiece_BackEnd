package com.example.onepiece.domain.board.service;


import com.example.onepiece.domain.board.domain.Board;
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
public class BoardImageUploadService {

    private final S3Facade s3Facade;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;

    @Transactional
    public void uploadBoardImage(MultipartFile boardImage, Long boardId) {

        User user = userFacade.getCurrentUser();
        Board board = boardFacade.getBoard(boardId);

        String boardImageUrl = s3Facade.uploadImage(boardImage);
        board.imageUpload(boardImageUrl);
    }
}
