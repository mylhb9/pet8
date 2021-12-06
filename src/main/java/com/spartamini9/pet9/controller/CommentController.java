package com.spartamini9.pet9.controller;


import com.spartamini9.pet9.config.UserDetailsImpl;
import com.spartamini9.pet9.dto.CommentDto;
import com.spartamini9.pet9.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    //댓글 저장
    @PostMapping("/posting/{id}/comment")
    public void registComment(@PathVariable Long id, @RequestBody CommentDto commentDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        commentService.saveComment(id, userId, commentDto);
    }

    //댓글 수정
    @PutMapping("/posting/{id}/comment/{commentid}")
    public void modifyComment(@PathVariable Long commentid, CommentDto commentDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.updateComment(commentid, commentDto);
    }

    //댓글 삭제
    @DeleteMapping("/posting/{id}/comment/{commentid}")
    public void deleteComment(@PathVariable Long commentid) {
        commentService.delete(commentid);
    }



}
