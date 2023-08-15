package com.example.onepiece.domain.feed.domain.repository;

import com.example.onepiece.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
