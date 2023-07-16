package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.exception.NicknameAlreadyExistsException;
import com.example.onepiece.domain.user.exception.UserIdAlreadyExistsException;
import com.example.onepiece.domain.user.presentation.dto.request.IdDuplicateRequest;
import com.example.onepiece.domain.user.presentation.dto.request.NicknameDuplicateRequest;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuplicateService {

    private final UserRepository userRepository;

    public void checkNicknameDuplicate(NicknameDuplicateRequest request) {
        if (userRepository.existsByNickname(request.getNickname())) {
            throw NicknameAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkUserIdDuplicate(IdDuplicateRequest request) {
        if (userRepository.existsByUserId(request.getAccountId())) {
            throw UserIdAlreadyExistsException.EXCEPTION;
        }
    }
}
