package com.example.User.domain.service;

import com.example.User.domain.controller.dto.request.UserDuplicateNicknameRequest;
import com.example.User.domain.controller.dto.request.UserDuplicateUserIdRequest;
import com.example.User.domain.controller.dto.request.UserSignUpRequest;
import com.example.User.domain.repository.UserRepository;
import com.example.User.domain.entity.User;
import com.example.User.global.security.error.ErrorCode;
import com.example.User.global.security.error.exception.CustomException;
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

    public void checkIdDuplicate(UserDuplicateUserIdRequest request){
        if(userRepository.existsByUserId(request.getUserId())){
            throw new CustomException(ErrorCode.USERId_ALREADY_EXISTS);
        }
    }

    public void checkNicknameDuplicate(UserDuplicateNicknameRequest request){
        if (userRepository.existsByNickname(request.getNickname())){
            throw new CustomException(ErrorCode.NICKNAME_ALREADY_EXISTS);
        }
    }
}
