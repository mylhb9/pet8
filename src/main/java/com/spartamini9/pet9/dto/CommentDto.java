package com.spartamini9.pet9.dto;


import com.spartamini9.pet9.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@Setter
@Getter
public class CommentDto {
    private String nickname;

    private String commentcontent;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public Comment toEntity(Long boardId, Long userId) {
        return Comment.builder()
                .nickname(nickname)
                .commentcontent(commentcontent)
                .userId(userId)
                .boardId(boardId)
                .build();
    }


}
