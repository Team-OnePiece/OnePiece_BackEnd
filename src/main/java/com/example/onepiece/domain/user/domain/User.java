package com.example.onepiece.domain.user.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userId;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 9)
    private String nickname;

    private String profileImage;

    @Column(nullable = false, length = 3)
    private Integer schoolNumber;

    @Column(nullable = false, length = 4)
    private Integer classNumber;

    @Column(nullable = false, length = 16)
    private Integer studentNumber;

    @Builder
    public User(String userId, String password, String nickname, String profileImage, Integer schoolNumber, Integer classNumber, Integer studentNumber) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.schoolNumber = schoolNumber;
        this.classNumber = classNumber;
        this.studentNumber = studentNumber;
    }
}
