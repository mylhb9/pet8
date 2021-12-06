package com.spartamini9.pet9.controller;



import com.spartamini9.pet9.dto.BoardRequestDto;
import com.spartamini9.pet9.dto.BoardResponseDto;
import com.spartamini9.pet9.entity.Board;
import com.spartamini9.pet9.repository.BoardRepository;
import com.spartamini9.pet9.repository.CommentRepository;
import com.spartamini9.pet9.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final BoardService boardService;

    //포스팅 입력받기
    @PostMapping("/api/posting")
    public String createPosting(@RequestBody BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return "게시글 작성이 완료되었습니다.";
    }

    //포스팅 목록 보여주기
    @GetMapping("/api/user/main")
    public List<BoardResponseDto> getPostings() {
        return boardService.findPostingList();
    }

}
