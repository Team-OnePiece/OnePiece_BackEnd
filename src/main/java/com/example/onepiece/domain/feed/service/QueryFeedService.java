package com.example.onepiece.domain.feed.service;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.feed.domain.repository.FeedRepository;
import com.example.onepiece.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.example.onepiece.domain.tag.domain.Tag;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    public List<QueryFeedResponse> findAllBoards() {

        User user = userFacade.getCurrentUser();

        return feedRepository.findAll()
                .stream()
                .map(this::queryFeedResponse)
                .collect(Collectors.toList());
    }

    private QueryFeedResponse queryFeedResponse(Feed feed) {
        return QueryFeedResponse.builder()
                .id(feed.getId())
                .boardImageUrl(feed.getBoardImageUrl())
                .place(feed.getPlace())
                .starCount(feed.getStarCounts())
                .createAt(feed.getCreatedAt())
                .nickname(feed.getUser().getNickname())
                .grade(feed.getUser().getGrade())
                .classNumber(feed.getUser().getClassNumber())
                .number(feed.getUser().getNumber())
                .profileImageUrl(feed.getUser().getProfileImageUrl())
                .tags(feed.getTags().stream().map(Tag::getTag).collect(Collectors.toList()))
                .build();

    }
}

