package com.example.onepiece.domain.star.domain.repository;


import com.example.onepiece.domain.board.domain.Board;
import com.example.onepiece.domain.star.domain.Star;
import com.example.onepiece.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Boolean existsByUserAndBoard(User user, Board board);
    void deleteByUserAndBoard(User user, Board board);
}

