package com.example.onepiece.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    @Column(name = "userId")
    private String userId;

    @NotNull
    @Column(name = "password")
    private String userPassword;

    @NotNull
    private String nickname;

    @Column(name = "profile_image")
    private String profile;

    @NotNull
    @Min(1) @Max(3)
    private Integer classNumber;

    @NotNull
    @Min(1) @Max(16)
    private Integer studentNumber;

    @Builder
    public User(String userId, String userPassword, String nickname, String profile ,Integer classNumber, Integer studentNumber){
        this.userId = userId;
        this.userPassword = userPassword;
        this.nickname = nickname;
        this.profile = profile;
        this.classNumber = classNumber;
        this.studentNumber = studentNumber;
    }
}
