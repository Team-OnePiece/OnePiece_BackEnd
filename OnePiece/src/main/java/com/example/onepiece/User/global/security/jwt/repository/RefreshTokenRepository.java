package com.example.onepiece.User.global.security.jwt.repository;

import com.example.onepiece.User.global.security.jwt.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
