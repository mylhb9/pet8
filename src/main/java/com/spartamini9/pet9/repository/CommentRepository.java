package com.spartamini9.pet9.repository;

import com.spartamini9.pet9.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
