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
    private String userId;

    @NotNull
    private String userPassword;

    @NotNull
    private String nickname;

    @NotNull
    @Min(1) @Max(3)
    private Integer classNumber;

    @NotNull
    @Min(1) @Max(16)
    private Integer studentNumber;

    @Builder
    public User(String userId, String userPassword, String nickname, Integer classNumber, Integer studentNumber){
        this.userId = userId;
        this.userPassword = userPassword;
        this.nickname = nickname;
        this.classNumber = classNumber;
        this.studentNumber = studentNumber;
    }
}
