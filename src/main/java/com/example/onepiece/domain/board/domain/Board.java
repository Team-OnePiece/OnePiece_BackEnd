package com.example.onepiece.domain.board.domain;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 10)
    private String place;

    @Column(nullable = false)
    private String image;

    @CreatedDate
    private LocalDateTime createdDatetime;

    @Builder
    public Board(User user, String place, String image) {
        this.user = user;
        this.place = place;
        this.image = image;
    }
}
