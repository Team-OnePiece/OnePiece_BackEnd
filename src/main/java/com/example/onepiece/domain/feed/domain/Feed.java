package com.example.onepiece.domain.feed.domain;

import com.example.onepiece.domain.tag.domain.Tag;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed extends BaseIdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.REMOVE)
    private List<Tag> tags = new ArrayList<>();

    @Column(nullable = false, length = 10)
    private String place;

    private String boardImageUrl = "";

    @CreatedDate
    private LocalDate createdAt;

    @NotNull
    private Integer starCounts;

    @Builder
    public Feed(User user, String place, Integer starCounts, Integer groupId) {
        this.user = user;
        this.place = place;
        this.starCounts = starCounts;
        this.createdAt = LocalDate.now();
    }

    public void imageUpload(String boardImageUrl) {
        this.boardImageUrl = boardImageUrl;
    }

    public void modifyPlaceAndBoardImageUrl(String place, String boardImageUrl) {
        this.place = place;
        this.boardImageUrl = boardImageUrl;
    }
  
    public void addStarCount() {
        this.starCounts += 1;
    }

    public void minusStarCount() {
        this.starCounts -= 1;
    }
}
