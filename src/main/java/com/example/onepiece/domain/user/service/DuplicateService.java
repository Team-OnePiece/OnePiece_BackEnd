package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.exception.NicknameAlreadyExistsException;
import com.example.onepiece.domain.user.exception.UserIdAlreadyExistsException;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuplicateService {

    private final UserRepository userRepository;

    public void checkNicknameDuplicate(String nickname) {
        if (userRepository.existsByNickname(nickname)) {
            throw NicknameAlreadyExistsException.EXCEPTION;
        }
    }

    public void checkAccountIdDuplicate(String accountId) {
        if (userRepository.existsByAccountId(accountId)) {
            throw UserIdAlreadyExistsException.EXCEPTION;
        }
    }
}
