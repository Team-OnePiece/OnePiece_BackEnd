package com.example.onepiece.domain.board.service;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.board.domain.repository.BoardRepository;
import com.example.onepiece.domain.board.presentation.dto.request.BoardCreateRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardIdResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public BoardIdResponse writeBoard(BoardCreateRequest request, MultipartFile boardImage) {
        User currentUser = userFacade.getCurrentUser();
        Board board = boardRepository.save(
                Board.builder()
                        .writer(currentUser)
                        .place(request.getPlace())
                        .build()
        );
        return new BoardIdResponse(board.getId());
        if(boardImage == null) {
        }
    }

}
