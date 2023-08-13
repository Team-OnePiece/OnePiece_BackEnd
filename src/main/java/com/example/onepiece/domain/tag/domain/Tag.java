package com.example.onepiece.domain.tag.domain;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Tag extends BaseIdEntity {

    private String tag;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "feed_id")
    private Feed feed;

    @Builder
    public Tag(String tag, User user, Feed feed) {
        this.tag = tag;
        this.user = user;
        this.feed = feed;
    }
}
