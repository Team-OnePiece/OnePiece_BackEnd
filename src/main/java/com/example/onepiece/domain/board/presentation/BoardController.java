package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.board.presentation.dto.response.QueryBoardResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import com.example.onepiece.domain.board.service.BoardModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.onepiece.domain.board.service.BoardImageUploadService;
import com.example.onepiece.domain.board.service.QueryBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardCreateService boardCreateService;
  
    private final BoardModifyService boardModifyService;
  
    private final QueryBoardService queryBoardService;
    private final BoardImageUploadService boardImageUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BoardCreateResponse writeBoard(@RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardCreateService.writeBoard(place, image);
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

    @PatchMapping("/{boardId}")
    public String modifyBoard(@PathVariable(value = "boardId") Long boardId, @RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardModifyService.modifyBoard(boardId, place, image);
    }
}
