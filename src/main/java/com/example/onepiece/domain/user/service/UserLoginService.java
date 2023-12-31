package com.example.onepiece.domain.user.service;

import com.example.onepiece.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.facade.UserFacade;
import com.example.onepiece.domain.user.exception.PasswordMissMatchException;
import com.example.onepiece.global.security.jwt.JwtProvider;
import com.example.onepiece.global.security.jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse userLogin(UserLoginRequest request) {

        User user = userFacade.getUserByAccountId(request.getAccountId());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMissMatchException.EXCEPTION;
        }
        return jwtProvider.getToken(user);
    }
}
