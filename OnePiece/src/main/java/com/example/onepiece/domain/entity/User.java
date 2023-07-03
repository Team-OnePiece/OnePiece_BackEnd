package com.example.onepiece.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String userId;

    private String userPassword;

    private String nickname;

    private Integer classNumber;

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
