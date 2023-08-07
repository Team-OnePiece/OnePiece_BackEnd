package com.example.onepiece.domain.user.presentation;

import com.example.onepiece.domain.user.presentation.dto.request.*;
import com.example.onepiece.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.onepiece.domain.user.service.*;
import com.example.onepiece.global.security.jwt.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Tag(name = "User API 입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserSignUpService userSignUpService;
    private final AccountIdDuplicateService accountIdDuplicateService;
    private final NicknameDuplicateService nicknameDuplicateService;
    private final UserLoginService userLoginService;
    private final UserInfoService userInfoService;
    private final UserUpdateService userUpdateService;
    private final UserProfileImageUploadService profileImageUploadService;
    private final StudentIdDuplicationService studentIdDuplicationService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.userSignUp(request);
    }

    @Operation(summary = "아이디 중복확인")
    @GetMapping("/id/duplicate")
    public void accountIdDuplicate(@RequestParam("account_id") String accountId) {
        accountIdDuplicateService.checkAccountIdDuplicate(accountId);
    }

    @Operation(summary = "별명 중복확인")
    @GetMapping("/nickname/duplicate")
    public void nicknameDuplicate(@RequestParam("nickname") String nickname) {
        nicknameDuplicateService.checkNicknameDuplicate(nickname);
    }

    @Operation(summary = "학번 중복확인")
    @GetMapping("/student/id/duplicate")
    public void studentIdDuplicate(@RequestParam("grade") Integer grade, @RequestParam("class_number") Integer classNumber, @RequestParam("number") Integer number) {
        studentIdDuplicationService.studentIdDuplicate(grade, classNumber, number);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginRequest request) {
        return userLoginService.userLogin(request);
    }

    @Operation(summary = "내 정보")
    @GetMapping("/info")
    public UserInfoResponse info() {
        return userInfoService.userInfo();
    }

    @Operation(summary = "별명 수정")
    @PatchMapping("/update")
    public void updateProfile(
            @RequestBody @Valid UserUpdateRequest request) {
        userUpdateService.userProfileUpdate(request);
    }

    @Operation(summary = "프로필 이미지 업로드")
    @PostMapping("/image/upload")
    public String upload(@RequestPart(required = false, value = "image") MultipartFile image) {
        return profileImageUploadService.userProfileImageUpload(image);
    }
}
