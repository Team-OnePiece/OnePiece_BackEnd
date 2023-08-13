package com.example.onepiece.domain.tag.domain.repository;

import com.example.onepiece.domain.tag.domain.Tag;
import com.example.onepiece.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
