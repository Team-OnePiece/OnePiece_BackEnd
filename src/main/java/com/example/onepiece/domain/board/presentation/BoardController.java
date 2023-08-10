package com.example.onepiece.domain.board.presentation;

import com.example.onepiece.domain.board.presentation.dto.request.BoardCreateRequest;
import com.example.onepiece.domain.board.presentation.dto.response.BoardCreateResponse;
import com.example.onepiece.domain.board.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardCreateService boardCreateService;

    @PostMapping
    public BoardCreateResponse writeBoard(@RequestBody @Valid BoardCreateRequest request, @RequestPart(required = false, value = "images") MultipartFile image) {
        return boardCreateService.writeBoard(request, image);
    }
}
