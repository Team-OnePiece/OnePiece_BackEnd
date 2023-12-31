package com.example.onepiece.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {

    @Pattern(regexp = "^[ㄱ-ㅎ가-힣]{2,8}$", message = "닉네임은 특수문자, 숫자, 영어를 제외한 2~8자 한글 사용하세요.")
    private String nickname;
}
