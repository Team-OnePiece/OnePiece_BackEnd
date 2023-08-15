package com.example.onepiece.domain.feed.service;

import com.example.onepiece.domain.feed.domain.repository.FeedRepository;
import com.example.onepiece.domain.feed.presentation.dto.response.QueryFeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedService {

    private final FeedRepository feedRepository;
    public List<QueryFeedResponse> queryGroupFeed() {

       return feedRepository.findAll()
                .stream()
                .map(QueryFeedResponse::queryFeedResponse)
                .collect(Collectors.toList());
    }
}
