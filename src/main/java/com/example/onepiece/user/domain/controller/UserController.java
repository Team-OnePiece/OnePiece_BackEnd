package com.example.onepiece.user.domain.controller;

import com.example.onepiece.user.domain.controller.dto.request.IdDuplicateRequest;
import com.example.onepiece.user.domain.controller.dto.request.NicknameDuplicateRequest;
import com.example.onepiece.user.domain.controller.dto.request.UserSignUpRequest;
import com.example.onepiece.user.domain.service.DuplicateService;
import com.example.onepiece.user.domain.service.UserSignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "UserAPI입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserSignUpService userSignUpService;
    private final DuplicateService duplicateService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void signUp(UserSignUpRequest request){
        userSignUpService.userSignUp(request);
    }

    @Operation(summary = "아이디 중복확인")
    @GetMapping("/idDuplicate")
    public void userIdDuplicate(IdDuplicateRequest request){
        duplicateService.checkUserIdDuplicate(request);
    }

    @Operation(summary = "별명 중복확인")
    @GetMapping("/nicknameDuplicate")
    public void nicknameDuplicate(NicknameDuplicateRequest request){
        duplicateService.checkNicknameDuplicate(request);
    }

}
