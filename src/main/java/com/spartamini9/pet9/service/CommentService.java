package com.spartamini9.pet9.service;


import com.spartamini9.pet9.dto.CommentDto;
import com.spartamini9.pet9.entity.Comment;
import com.spartamini9.pet9.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 저장 메소드
    @Transactional
    public void saveComment(Long id, Long userId, CommentDto commentDto) {
        commentRepository.save(commentDto.toEntity(id, userId));
    }

    //댓글 수정 메소드
    @Transactional
    public void updateComment(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        comment.update(commentDto);

    }

    //댓글 삭제 메소드
    @Transactional
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}
