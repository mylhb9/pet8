package com.spartamini9.pet9.repository;

import com.spartamini9.pet9.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
