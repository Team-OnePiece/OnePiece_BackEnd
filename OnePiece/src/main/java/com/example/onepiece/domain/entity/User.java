package com.example.onepiece.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    @NotBlank(message = "아이디는 필수 입력 값 입니다")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{1,16}", message = "비밀번호는 1~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String userPassword;

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,9}$", message = "닉네임은 특수문자를 제외한 2~9자리여야 합니다.")
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
