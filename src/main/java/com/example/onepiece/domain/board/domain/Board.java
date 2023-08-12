package com.example.onepiece.domain.board.domain;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.global.entity.BaseIdEntity;
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
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board extends BaseIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 10)
    private String place;

    private String boardImageUrl = "";

    @CreatedDate
    private LocalDate createdAt;

    @NotNull
    private Integer starCounts;

    @Builder
    public Board(User user, String place, Integer starCounts) {
        this.user = user;
        this.place = place;
        this.starCounts = starCounts;
        this.createdAt = LocalDate.now();
    }

    public void imageUpload(String boardImageUrl) {
        this.boardImageUrl = boardImageUrl;
    }


    public void modifyPlaceAndBoardImageUrl(String boardImageUrl, String place) {
        this.boardImageUrl = boardImageUrl;
        this.place = place;
    }
  
    public void addStarCount() {
        this.starCounts += 1;
    }

    public void minusStarCount() {
        this.starCounts -= 1;
    }
}
