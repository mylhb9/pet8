package com.spartamini9.pet9.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BoardRequestDto {
    private String username;
    private String title;
    private String content;
    private String img;
    private String category;

}
