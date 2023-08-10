package com.example.onepiece.domain.star.presentation;


import com.example.onepiece.domain.star.presentation.dto.response.StarResponse;
import com.example.onepiece.domain.star.presentation.dto.response.UnStarResponse;
import com.example.onepiece.domain.star.service.StarService;
import com.example.onepiece.domain.star.service.UnStarService;
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
    private final UnStarService unStarService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/star/{board-id}")
    public StarResponse star(@PathVariable("board-id") Long boardId){
        return starService.Star(boardId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/star/{board-id}")
    public StarResponse deleteStar(@PathVariable("board-id") Long boardId){
        return starService.deleteStar(boardId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/star/{board-id}")
    public UnStarResponse unStar(@PathVariable("board-id") Long boardId){
        return unStarService.unStar(boardId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/star/{board-id}")
    public UnStarResponse deleteUnStar(@PathVariable("board-id") Long boardId){
        return unStarService.deleteUnStar(boardId);
    }
}
