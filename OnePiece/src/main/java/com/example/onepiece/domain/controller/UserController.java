package com.example.onepiece.domain.controller;

import com.example.onepiece.domain.controller.dto.request.UserAddRequest;
import com.example.onepiece.domain.controller.dto.request.UserDuplicateNicknameRequest;
import com.example.onepiece.domain.controller.dto.request.UserDuplicateUserIdRequest;
import com.example.onepiece.domain.service.Duplicate;
import com.example.onepiece.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User", description = "User API 입니다")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Duplicate duplicate;

    @Operation(summary = "User회원가입")
    @PostMapping
    public void userSignUp(@RequestBody @Valid UserAddRequest request){
        userService.signUpUser(request);
    }

    @Operation(summary = "Id중복확인")
    @GetMapping("/idDuplicate")
    public Boolean userIdDuplicate(@RequestBody @Valid UserDuplicateUserIdRequest request){
       return duplicate.idDuplicate(request);
    }

    @Operation(summary = "Nickname중복확인")
    @GetMapping("/nicknameDuplicate")
    public void userNicknameDuplicate(@RequestBody @Valid UserDuplicateNicknameRequest request){
        duplicate.nicknameDuplicate(request);
    }
}
