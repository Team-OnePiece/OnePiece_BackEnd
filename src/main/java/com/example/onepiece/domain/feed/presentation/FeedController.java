package com.example.onepiece.domain.feed.presentation;

import com.example.onepiece.domain.feed.presentation.dto.response.CreateFeedResponse;
import com.example.onepiece.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.example.onepiece.domain.feed.service.DeleteFeedService;
import com.example.onepiece.domain.feed.service.CreateFeedService;
import com.example.onepiece.domain.feed.service.ModifyFeedService;
import com.example.onepiece.domain.feed.service.QueryFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class FeedController {

    private final CreateFeedService createFeedService;
    private final ModifyFeedService modifyFeedService;
    private final QueryFeedService queryFeedService;
    private final DeleteFeedService deleteFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateFeedResponse boardCreate(@RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return createFeedService.createBoard(place, image);
    }

    @GetMapping("/all")
    public List<QueryFeedResponse> findBoardAll() {
        return queryFeedService.findAllBoards();
    }

    @PatchMapping("/{boardId}")
    public void boardDelete(@PathVariable(value = "boardId") Long boardId, @RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        modifyFeedService.modifyBoard(boardId, place, image);
    }

    @DeleteMapping("/{boardId}")
    public void boardDelete(@PathVariable(value = "boardId") Long boardId) {
        deleteFeedService.deleteBoard(boardId);
    }
}
