package com.example.onepiece.domain.service;

import com.example.onepiece.domain.controller.dto.request.UserAddRequest;
import com.example.onepiece.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final Duplicate duplicate;
    private final UserRepository userRepository;

    @Transactional
    public void signUpUser(UserAddRequest request) {

    }
}
