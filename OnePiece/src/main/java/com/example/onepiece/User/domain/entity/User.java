package com.example.onepiece.User.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String userPassword;

    private String nickname;

    private String profile;

    private Integer schoolNumber;

    private Integer classNumber;

    private Integer studentNumber;

    @Builder
    public User(String userId, String userPassword, String nickname, String profile ,Integer schoolNumber ,Integer classNumber, Integer studentNumber){
        this.userId = userId;
        this.userPassword = userPassword;
        this.nickname = nickname;
        this.profile = profile;
        this.schoolNumber = schoolNumber;
        this.classNumber = classNumber;
        this.studentNumber = studentNumber;
    }
}
