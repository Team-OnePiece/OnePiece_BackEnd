package com.example.onepiece.user.domain.service;

import com.example.onepiece.user.domain.controller.dto.request.UserLoginRequest;
import com.example.onepiece.user.domain.entity.User;
import com.example.onepiece.user.domain.service.facade.UserFacade;
import com.example.onepiece.user.global.error.ErrorCode;
import com.example.onepiece.user.global.error.exception.CustomException;
import com.example.onepiece.user.global.security.Jwt.JwtProvider;
import com.example.onepiece.user.global.security.Jwt.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final UserFacade userFacade;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse userLogin(UserLoginRequest request){

        User user = userFacade.getUserByUserId(request.getUserId());

        if(!passwordEncoder.matches(request.getUserPassword(), user.getUserPassword())){
            throw new CustomException(ErrorCode.PASSWORD_MISS_MATCH);
        }
        return jwtProvider.getToken(user);
    }
}
