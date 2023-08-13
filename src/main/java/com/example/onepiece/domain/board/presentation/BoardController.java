package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import com.example.onepiece.domain.board.service.QueryBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final QueryBoardService queryBoardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BoardCreateResponse writeBoard(@RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardCreateService.writeBoard(place, image);
    }

    @GetMapping("/all")
    public List<QueryBoardResponse> findBoardAll() {
        return queryBoardService.findAllBoards();
    }
}
