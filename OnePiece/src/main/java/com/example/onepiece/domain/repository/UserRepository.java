package com.example.onepiece.domain.repository;

import com.example.onepiece.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
