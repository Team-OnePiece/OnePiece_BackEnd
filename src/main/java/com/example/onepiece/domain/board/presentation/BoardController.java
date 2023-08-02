package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.request.BoardRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardIdResponse;
import com.example.onepiece.domain.board.presentation.dto.response.BoardResponse;
import com.example.onepiece.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public BoardIdResponse writeBoard(@Valid @RequestBody BoardRequest request) {
        return boardService.writeBoard(request);
    }
}
