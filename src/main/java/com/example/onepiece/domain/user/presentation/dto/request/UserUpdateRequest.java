package com.example.onepiece.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣]{2,8}$", message = "닉네임은 특수문자, 숫자, 영어를 제외한 2~9자 한글 사용하세요.")
    private String nickname;
}
