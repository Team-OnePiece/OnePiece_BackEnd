package com.example.onepiece.domain.service;

import com.example.onepiece.domain.controller.dto.request.UserAddRequest;
import com.example.onepiece.domain.entity.User;
import com.example.onepiece.domain.repository.UserRepository;
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
    public void signUpUser(UserAddRequest request) {

        userRepository.save(
                User.builder()
                        .userId(request.getUserId())
                        .userPassword(request.getUserPassword())
                        .nickname(passwordEncoder.encode(request.getNickname()))
                        .classNumber(request.getClassNumber())
                        .studentNumber(request.getStudentNumber())
                        .profile(request.getProfile())
                        .build());
    }

}
