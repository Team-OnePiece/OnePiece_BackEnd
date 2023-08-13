package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.response.CreateBoardResponse;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.board.service.CreateBoardService;
import com.example.onepiece.domain.board.service.ModifyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.onepiece.domain.board.service.QueryBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final CreateBoardService boardCreateService;
    private final ModifyBoardService boardModifyService;
    private final QueryBoardService queryBoardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateBoardResponse writeBoard(@RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardCreateService.writeBoard(place, image);
    }

    @GetMapping("/all")
    public List<QueryBoardResponse> findBoardAll() {
        return queryBoardService.findAllBoards();
    }

    @PatchMapping("/{boardId}")
    public void modifyBoard(@PathVariable(value = "boardId") Long boardId, @RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        boardModifyService.modifyBoard(boardId, place, image);
    }
}
