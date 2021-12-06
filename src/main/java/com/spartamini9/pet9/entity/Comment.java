package com.spartamini9.pet9.entity;


import com.spartamini9.pet9.dto.CommentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String commentcontent;

    @Column(nullable = false)
    private Long boardId;

    @Column(nullable = false)
    private Long userId;


    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder
    public Comment(String nickname, String commentcontent, Long boardId, Long userId) {
        this.nickname = nickname;
        this.commentcontent = commentcontent;
        this.boardId = boardId;
        this.userId = userId;
    }
    public void update(CommentDto commentDto) {
        this.commentcontent = commentDto.getCommentcontent();
    }



}
