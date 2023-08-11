package com.example.onepiece.domain.board.domain;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.global.entity.BaseIdEntity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
    public Board(User writer, String place) {
        this.user = writer;
        this.place = place;
    }

    public void imageUpload(String boardImageUrl) {
        this.boardImageUrl = boardImageUrl;
    }

}
