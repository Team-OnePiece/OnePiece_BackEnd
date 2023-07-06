package com.example.onepiece.User.domain.repository;

import com.example.onepiece.User.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);

    boolean existsByNickname(String nickname);
}
