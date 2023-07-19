package com.example.onepiece.domain.user.domain.repository;

import com.example.onepiece.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccountId(String accountId);

    List<User> findByUser(User user);

    boolean existsByAccountId(String accountId);

    boolean existsByNickname(String nickname);
}
