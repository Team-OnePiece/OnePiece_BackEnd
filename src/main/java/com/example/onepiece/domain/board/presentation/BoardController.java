package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.request.BoardCreateRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import com.example.onepiece.domain.board.service.BoardModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardCreateService boardCreateService;
    private final BoardModifyService boardModifyService;

    @PostMapping
    public BoardCreateResponse writeBoard(@RequestBody @Valid BoardCreateRequest request, @RequestPart(required = false, value = "images") MultipartFile image) {
        return boardCreateService.writeBoard(request, image);
    }

    @PatchMapping("/update/{boardId}")
    public String modifyBoard(@PathVariable(value = "boardId") Long boardId, @RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return boardModifyService.modifyBoard(boardId, place, image);
    }
}