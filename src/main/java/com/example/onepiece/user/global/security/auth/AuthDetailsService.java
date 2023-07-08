package com.example.onepiece.user.global.security.auth;

import com.example.onepiece.user.domain.entity.User;
import com.example.onepiece.user.domain.repository.UserRepository;
import com.example.onepiece.user.global.security.error.ErrorCode;
import com.example.onepiece.user.global.security.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId){
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return new AuthDetails(user);
    }
}