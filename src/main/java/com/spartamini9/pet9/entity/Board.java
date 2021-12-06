package com.spartamini9.pet9.entity;



import com.spartamini9.pet9.dto.BoardRequestDto;
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
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String img;

    @Column
    private String category;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Board(BoardRequestDto boardRequestDto) {
        this.username = boardRequestDto.getUsername();
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.img = boardRequestDto.getImg();
        this.category = boardRequestDto.getCategory();
    }
}
