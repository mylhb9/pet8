package com.spartamini9.pet9.service;

import com.spartamini9.pet9.entity.User;
import com.spartamini9.pet9.repository.UserRepository;
import com.spartamini9.pet9.userdto.SignupRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public String userRegister(SignupRequestDto signupRequestDto) {

        String email = signupRequestDto.getEmail();
        Optional<User> foundEmail = userRepository.findByEmail(email);
        //아이디 중복검사
        if(foundEmail.isPresent()){
            throw new IllegalArgumentException ("아이디가 존재합니다.");
        }


        String nickname = signupRequestDto.getNickname();
        Optional<User> foundNickname = userRepository.findByNickname(nickname);
        //닉네임 중복검사
        if(foundNickname.isPresent()){
            throw new IllegalArgumentException ("닉네임이 존재합니다.");
        }

        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        String passwordCheck = passwordEncoder.encode(signupRequestDto.getPasswordCheck());


        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException( "패스워드가 일치하지 않습니다.");
        }

        User user = new User(email,password,nickname);
        userRepository.save(user);
        return "저장완료";

    }
}
