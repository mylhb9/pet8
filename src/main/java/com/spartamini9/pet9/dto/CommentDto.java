package com.spartamini9.pet9.dto;


import com.spartamini9.pet9.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@AllArgsConstructor
@Setter
@Getter
public class CommentDto {
    private String username;

    private String commentcontent;



    public Comment toEntity(Long boardId, Long userId) {
        return Comment.builder()
                .username(username)
                .commentcontent(commentcontent)
                .userId(userId)
                .boardId(boardId)
                .build();
    }


}
