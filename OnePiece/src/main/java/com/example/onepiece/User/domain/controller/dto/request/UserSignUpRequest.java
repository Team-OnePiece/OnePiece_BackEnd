package com.example.onepiece.User.domain.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{1,20}$", message = "아이디는 1~20자 영문 대 소문자, 숫자 사용하세요")
    private String userId;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{1,16}", message = "비밀번호는 1~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String userPassword;

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z]{2,9}$", message = "닉네임은 특수문자, 숫자를 제외한 2~9자 한글 영문 대 소문자 사용하세요.")
    private String nickname;

    @Column(name = "profile_image")
    private String profile;

    @NotNull
    @Min(1) @Max(3)
    private Integer schoolNumber;

    @NotNull
    @Min(1) @Max(4)
    private Integer classNumber;

    @NotNull
    @Min(1) @Max(18)
    private Integer studentNumber;

}
