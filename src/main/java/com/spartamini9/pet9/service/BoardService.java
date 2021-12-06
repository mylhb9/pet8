package com.spartamini9.pet9.service;


import com.spartamini9.pet9.dto.BoardResponseDto;
import com.spartamini9.pet9.entity.Board;
import com.spartamini9.pet9.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardResponseDto> findPostingList() {
        List<BoardResponseDto> BoardResponseDtoList = new ArrayList<>();
        List<Board> BoardList = boardRepository.findAllByOrderByModifiedAtDesc();
        return BoardResponseDtoList;
    }



}
