package com.example.onepiece.domain.star.presentation;


import com.example.onepiece.domain.star.presentation.dto.response.StarResponse;
import com.example.onepiece.domain.star.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/star")
@RestController
public class StarController {
    private final StarService starService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{board-id}/star")
    public StarResponse star(@PathVariable("board-id") Long boardId){
        return starService.star(boardId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{board-id}/delete-star")
    public StarResponse deleteStar(@PathVariable("board-id") Long boardId){
        return starService.deleteStar(boardId);
    }
}
