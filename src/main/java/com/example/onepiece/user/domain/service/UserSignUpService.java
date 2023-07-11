package com.example.onepiece.user.domain.service;

import com.example.onepiece.user.domain.controller.dto.request.UserSignUpRequest;
import com.example.onepiece.user.domain.entity.User;
import com.example.onepiece.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void userSignUp(UserSignUpRequest request) {
        userRepository.save(
                User.builder()
                        .userId(request.getUserId())
                        .userPassword(passwordEncoder.encode(request.getUserPassword()))
                        .nickname(request.getNickname())
                        .profile(request.getProfile())
                        .schoolNumber(request.getSchoolNumber())
                        .classNumber(request.getClassNumber())
                        .studentNumber(request.getStudentNumber())
                        .build());
    }
}
