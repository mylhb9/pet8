package com.spartamini9.pet9.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@AllArgsConstructor
@Setter
public class User {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "BOARD_ID")
//    private List<Board> boards;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "COMMENT_ID")
//    private List<Comment> comments;


    public User(String email,String password,String nickname){
        this.email=email;
        this.password=password;
        this.nickname=nickname;
    }
}


