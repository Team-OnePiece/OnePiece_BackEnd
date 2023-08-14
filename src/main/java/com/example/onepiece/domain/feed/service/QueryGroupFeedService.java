package com.example.onepiece.domain.feed.service;

import com.example.onepiece.domain.feed.domain.repository.FeedRepository;
import com.example.onepiece.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryGroupFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    public List<QueryFeedResponse> queryGroupFeed(Integer groupId) {

        User user = userFacade.getCurrentUser();

       return feedRepository.findByGroupId(groupId)
                .stream()
                .map(QueryFeedResponse::queryFeedResponse)
                .collect(Collectors.toList());
    }
}
