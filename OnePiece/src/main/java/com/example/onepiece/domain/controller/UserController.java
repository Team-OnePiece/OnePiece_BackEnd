package com.example.onepiece.domain.controller;

import com.example.onepiece.domain.controller.dto.request.UserAddRequest;
import com.example.onepiece.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void userAdd(@RequestBody UserAddRequest request){
        userService.addUser(request);
    }

}