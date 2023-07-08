package com.example.User.domain.controller;

import com.example.User.domain.controller.dto.request.UserDuplicateUserIdRequest;
import com.example.User.domain.controller.dto.request.UserSignUpRequest;
import com.example.User.domain.controller.dto.request.UserDuplicateNicknameRequest;
import com.example.User.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User", description = "User API 입니다")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "User회원가입")
    @PostMapping
    public void userSignUp(@RequestBody @Valid UserSignUpRequest request){
        userService.signUpUser(request);
    }

    @Operation(summary = "Id중복확인")
    @GetMapping("/idDuplicate")
    public Boolean userIdDuplicate(@RequestBody @Valid UserDuplicateUserIdRequest request){
       return duplicate.idDuplicate(request);
    }

    @Operation(summary = "Nickname중복확인")
    @GetMapping("/nicknameDuplicate")
    public boolean userNicknameDuplicate(@RequestBody @Valid UserDuplicateNicknameRequest request){
       return duplicate.nicknameDuplicate(request);
    }
}
