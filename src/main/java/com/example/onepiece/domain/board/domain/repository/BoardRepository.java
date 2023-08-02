package com.example.onepiece.domain.board.domain.repository;

import com.example.onepiece.domain.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository <Board, Long> {

}
