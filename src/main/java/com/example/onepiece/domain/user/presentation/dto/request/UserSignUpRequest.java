package com.example.onepiece.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{7,20}$", message = "아이디는 ７~20자 영문 대 소문자, 숫자 사용하세요")
    private String accountId;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{7,20}", message = "비밀번호는 7~20자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    private String passwordValid;

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣]{2,8}$", message = "닉네임은 특수문자, 숫자, 영어를 제외한 2~9자 한글 사용하세요.")
    private String nickname;
    
    @NotNull
    @Min(1) @Max(3)
    private Integer grade;

    @NotNull
    @Min(1) @Max(4)
    private Integer classNumber;

    @NotNull
    @Min(1) @Max(18)
    private Integer number;

}
