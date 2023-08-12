package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import com.example.onepiece.domain.board.service.BoardImageUploadService;
import com.example.onepiece.domain.board.service.QueryBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final QueryBoardService queryBoardService;
    private final BoardImageUploadService boardImageUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BoardCreateResponse writeBoard(@RequestParam("place") String place) {
        return boardCreateService.writeBoard(place);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/image/upload/{boardId}")
    public void boardImageUpload(@PathVariable(value = "boardId") Long boardId, @RequestPart(required = false, value = "image") MultipartFile image) {
        boardImageUploadService.uploadBoardImage(image, boardId);
    }

    @GetMapping("/all")
    public List<QueryBoardResponse> findBoardAll() {
        return queryBoardService.findAllBoards();
    }
}
