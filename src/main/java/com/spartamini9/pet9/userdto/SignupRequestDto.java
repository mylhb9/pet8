package com.spartamini9.pet9.userdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignupRequestDto {

    private String email;
    private String password;
    private String passwordCheck;
    private String nickname;

}
