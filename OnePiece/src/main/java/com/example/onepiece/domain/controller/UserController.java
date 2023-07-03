package com.example.onepiece.domain.controller;

import com.example.onepiece.domain.controller.dto.request.UserSignUpRequest;
import com.example.onepiece.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void userSignUp(@RequestBody @Valid UserSignUpRequest request){
        userService.signUpUser(request);
    }

}
