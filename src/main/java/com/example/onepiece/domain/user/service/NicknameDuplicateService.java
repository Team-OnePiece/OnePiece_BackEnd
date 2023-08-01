package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.exception.NicknameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NicknameDuplicateService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public void checkNicknameDuplicate(String nickname) {
        if (userRepository.existsByNickname(nickname)) {
            throw NicknameAlreadyExistsException.EXCEPTION;
        }
    }
}
