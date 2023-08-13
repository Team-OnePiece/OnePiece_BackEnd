package com.example.onepiece.domain.user.presentation;

import com.example.onepiece.domain.user.presentation.dto.request.*;
import com.example.onepiece.domain.user.presentation.dto.response.QuerySchoolNumberResponse;
import com.example.onepiece.domain.user.presentation.dto.response.QueryUserInfoResponse;
import com.example.onepiece.domain.user.service.*;
import com.example.onepiece.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserSignUpService userSignUpService;
    private final AccountIdDuplicateService accountIdDuplicateService;
    private final NicknameDuplicateService nicknameDuplicateService;
    private final UserLoginService userLoginService;
    private final QueryUserInfoService queryUserInfoService;
    private final UserUpdateService userUpdateService;
    private final UserProfileImageUploadService profileImageUploadService;
    private final StudentIdDuplicationService studentIdDuplicationService;
    private final QuerySchoolNumberService querySchoolNumberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.userSignUp(request);
    }

    @GetMapping("/id/duplicate")
    public void accountIdDuplicate(@RequestParam("account_id") String accountId) {
        accountIdDuplicateService.checkAccountIdDuplicate(accountId);
    }

    @GetMapping("/nickname/duplicate")
    public void nicknameDuplicate(@RequestParam("nickname") String nickname) {
        nicknameDuplicateService.checkNicknameDuplicate(nickname);
    }

    @GetMapping("/student/id/duplicate")
    public void studentIdDuplicate(@RequestParam("grade") Integer grade, @RequestParam("class_number") Integer classNumber, @RequestParam("number") Integer number) {
        studentIdDuplicationService.studentIdDuplicate(grade, classNumber, number);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginRequest request) {
        return userLoginService.userLogin(request);
    }

    @GetMapping("/info")
    public QueryUserInfoResponse info() {
        return queryUserInfoService.userInfo();
    }

    @PatchMapping("/update")
    public void updateProfile(
            @RequestBody @Valid UserUpdateRequest request) {
        userUpdateService.userProfileUpdate(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/image/upload")
    public void upload(@RequestPart(required = false, value = "image") MultipartFile image) {
        profileImageUploadService.userProfileImageUpload(image);
    }
    
    @GetMapping("/group")
    public QuerySchoolNumberResponse schoolNumberQuery() {
        return querySchoolNumberService.querySchoolNumber();
    }
}
