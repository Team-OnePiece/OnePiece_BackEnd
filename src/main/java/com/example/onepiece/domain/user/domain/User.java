package com.example.onepiece.domain.user.domain;

import lombok.*;

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

    @Column(nullable = false, length = 9)
    private String nickname;

    private String profile;

    @Column(nullable = false, length = 3)
    private Integer schoolNumber;

    @Column(nullable = false, length = 4)
    private Integer classNumber;

    @Column(nullable = false, length = 16)
    private Integer studentNumber;

    public void update(String nickname, String profile){
        this.nickname = nickname;
        this.profile = profile;
    }

    @Builder
    public User(String userId, String userPassword, String nickname, String profile, Integer schoolNumber, Integer classNumber, Integer studentNumber) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.nickname = nickname;
        this.profile = profile;
        this.schoolNumber = schoolNumber;
        this.classNumber = classNumber;
        this.studentNumber = studentNumber;
    }
}
