package com.example.onepiece.domain.feed.presentation;

import com.example.onepiece.domain.feed.presentation.dto.response.CreateFeedResponse;
import com.example.onepiece.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.example.onepiece.domain.feed.service.DeleteFeedService;
import com.example.onepiece.domain.feed.service.CreateFeedService;
import com.example.onepiece.domain.feed.service.ModifyFeedService;
import com.example.onepiece.domain.feed.service.QueryGroupFeedService;
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
@RequestMapping("/feed")
public class FeedController {

    private final CreateFeedService createFeedService;
    private final ModifyFeedService modifyFeedService;
    private final QueryGroupFeedService queryGroupFeedService;
    private final DeleteFeedService deleteFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{groupId}")
    public CreateFeedResponse feedCreate(@RequestParam(value = "place") String place, @PathVariable(value = "groupId") Integer groupId , @RequestPart(required = false, value = "image") MultipartFile image) {
        return createFeedService.createFeed(place, groupId,image);
    }

    @GetMapping("/{groupId}")
    public List<QueryFeedResponse> feedGroupQuery(@PathVariable(value = "groupId") Integer groupId) {
        return queryGroupFeedService.queryGroupFeed(groupId);
    }

    @PatchMapping("/{feedId}")
    public void feedModify(@PathVariable(value = "feedId") Long feedId, @RequestParam(value = "place") String place, @RequestPart(required = false, value = "image") MultipartFile image) {
        modifyFeedService.modifyFeed(feedId, place, image);
    }

    @DeleteMapping("/{feedId}")
    public void feedDelete(@PathVariable(value = "feedId") Long feedId) {
        deleteFeedService.deleteFeed(feedId);
    }
}
