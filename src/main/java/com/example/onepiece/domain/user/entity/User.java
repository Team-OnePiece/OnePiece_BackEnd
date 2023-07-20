package com.example.onepiece.domain.user.entity;

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

    @Column(nullable = false, length = 20)
    private String userId;

    @Column(nullable = false, length = 60)
    private String userPassword;

    @Column(nullable = false, length = 4)
    private String nickname;

    private String profile;

    @Column(nullable = false, length = 3)
    private Integer schoolNumber;

    @Column(nullable = false, length = 4)
    private Integer classNumber;

    @Column(nullable = false, length = 18)
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