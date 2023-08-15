package com.example.onepiece.domain.feed.presentation;

import com.example.onepiece.domain.feed.presentation.dto.response.CreateFeedResponse;
import com.example.onepiece.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.example.onepiece.domain.feed.service.DeleteFeedService;
import com.example.onepiece.domain.feed.service.CreateFeedService;
import com.example.onepiece.domain.feed.service.ModifyFeedService;
import com.example.onepiece.domain.feed.service.QueryFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final ModifyFeedService modifyFeedService;
    private final QueryFeedService queryFeedService;
    private final DeleteFeedService deleteFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateFeedResponse feedCreate(@RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        return createFeedService.createFeed(place,image);
    }

    @GetMapping
    public List<QueryFeedResponse> feedGroupQuery() {
        return queryFeedService.queryGroupFeed();
    }

    @PatchMapping("/{feedId}")
    public void feedModify(@PathVariable(value = "feedId") Long feedId, @RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        modifyFeedService.modifyFeed(feedId, place, image);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feedId}")
    public void feedDelete(@PathVariable(value = "feedId") Long feedId) {
        deleteFeedService.deleteFeed(feedId);
    }
}
