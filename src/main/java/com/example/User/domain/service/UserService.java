package com.example.User.domain.service;

import com.example.User.domain.controller.dto.request.UserSignUpRequest;
import com.example.User.domain.repository.UserRepository;
import com.example.User.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUpUser(UserSignUpRequest request) {

        userRepository.save(
                User.builder()
                        .userId(request.getUserId())
                        .userPassword(passwordEncoder.encode(request.getUserPassword()))
                        .nickname(request.getNickname())
                        .schoolNumber(request.getSchoolNumber())
                        .classNumber(request.getClassNumber())
                        .studentNumber(request.getStudentNumber())
                        .profile(request.getProfile())
                        .build());
    }

}
