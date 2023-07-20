package com.example.onepiece.domain.profileImage.domain;

import com.example.onepiece.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileImageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public ProfileImage(User user, String profileImageUrl){
        this.user = user;
        this.profileImageUrl = profileImageUrl;
    }
}
