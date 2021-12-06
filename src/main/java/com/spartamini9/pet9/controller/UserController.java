package com.spartamini9.pet9.controller;

import com.spartamini9.pet9.service.UserService;
import com.spartamini9.pet9.userdto.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/api/user/signup")
    public String userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.userRegister(signupRequestDto);

        return "회원가입성공";
    }



}
