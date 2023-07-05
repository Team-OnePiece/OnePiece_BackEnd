package com.example.onepiece.domain.controller;

import com.example.onepiece.domain.controller.dto.request.UserAddRequest;
import com.example.onepiece.domain.controller.dto.request.UserDuplicateNicknameRequest;
import com.example.onepiece.domain.controller.dto.request.UserDuplicateUserIdRequest;
import com.example.onepiece.domain.service.Duplicate;
import com.example.onepiece.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Duplicate duplicate;

    @PostMapping
    public void userSignUp(@RequestBody @Valid UserAddRequest request){
        userService.signUpUser(request);
    }

    @GetMapping("/idDuplicate")
    public Boolean userIdDuplicate(@RequestBody @Valid UserDuplicateUserIdRequest request){
       return duplicate.idDuplicate(request);
    }

    @GetMapping("/nicknameDuplicate")
    public void userNicknameDuplicate(@RequestBody @Valid UserDuplicateNicknameRequest request){
        duplicate.nicknameDuplicate(request);
    }
}
