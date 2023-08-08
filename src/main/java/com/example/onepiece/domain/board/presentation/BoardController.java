package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.request.BoardRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardIdResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardCreateService boardCreateService;

    @PostMapping("/board")
    public BoardIdResponse writeBoard(@Valid @RequestBody BoardRequest request) {
        return boardCreateService.writeBoard(request);
    }
}
