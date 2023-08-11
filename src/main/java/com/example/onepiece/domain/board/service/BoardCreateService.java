package com.example.onepiece.domain.board.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.request.BoardCreateRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.infra.s3.service.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

    public BoardCreateResponse writeBoard(BoardCreateRequest request, MultipartFile boardImage) {

        User currentUser = userFacade.getCurrentUser();
        Board board = boardRepository.save(
                Board.builder()
                        .user(currentUser)
                        .place(request.getPlace())
                        .build()
        );

        String boardImageUrl = s3Facade.uploadImage(boardImage);
        board.imageUpload(boardImageUrl);

        return new BoardCreateResponse(board.getId(), boardImageUrl);
    }

}
