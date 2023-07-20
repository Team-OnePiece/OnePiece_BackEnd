package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.exception.PasswordMissMatchException;
import com.example.onepiece.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void userSignUp(UserSignUpRequest request) {

        if (!request.getPassword().equals(request.getPasswordValid())){
            throw PasswordMissMatchException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .nickname(request.getNickname())
                        .grade(request.getGrade())
                        .classNumber(request.getClassNumber())
                        .number(request.getNumber())
                        .build());
    }
}
