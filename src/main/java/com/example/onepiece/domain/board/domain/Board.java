package com.example.onepiece.domain.board.domain;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 10)
    private String place;

    @Column(nullable = false)
    private String image;

    @Builder
    public Board(User user, String place, String image) {
        this.user = user;
        this.place = place;
        this.image = image;
    }
}
