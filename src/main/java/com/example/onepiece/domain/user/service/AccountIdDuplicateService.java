package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.exception.AccountIdAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountIdDuplicateService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public void checkAccountIdDuplicate(String accountId) {
        if (userRepository.existsByAccountId(accountId)) {
            throw AccountIdAlreadyExistsException.EXCEPTION;
        }
    }
}
