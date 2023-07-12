package com.example.onepiece.global.security.auth;

import com.example.onepiece.domain.user.entity.User;
import com.example.onepiece.domain.user.repository.UserRepository;
import com.example.onepiece.global.security.error.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new AuthDetails(user);
    }
}
