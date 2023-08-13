package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.response.CreateBoardResponse;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.board.service.DeleteBoardService;
import com.example.onepiece.domain.board.service.CreateBoardService;
import com.example.onepiece.domain.board.service.QueryBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final CreateBoardService boardCreateService;
    private final QueryBoardService queryBoardService;
    private final DeleteBoardService deleteBoardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateBoardResponse boardCreate(@RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardCreateService.createBoard(place, image);
    }

    @GetMapping("/all")
    public List<QueryBoardResponse> findBoardAll() {
        return queryBoardService.findAllBoards();
    }

    @DeleteMapping("/delete/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        deleteBoardService.deleteBoard(boardId);
    }
}
