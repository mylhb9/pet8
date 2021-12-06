package com.spartamini9.pet9.service;

import com.spartamini9.pet9.entity.User;
import com.spartamini9.pet9.repository.UserRepository;
import com.spartamini9.pet9.userdto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;



    public String userRegister(SignupRequestDto signupRequestDto) {

        String email = signupRequestDto.getEmail();
        Optional<User> foundEmail = userRepository.findByEmail(email);
        //아이디 중복검사
        if(foundEmail.isPresent()){
            throw new IllegalArgumentException ("아이디가 존재합니다.");
        }


        String username = signupRequestDto.getUsername();
        Optional<User> foundUsername = userRepository.findByUsername(username);
        //닉네임 중복검사
        if(foundUsername.isPresent()){
            throw new IllegalArgumentException ("닉네임이 존재합니다.");
        }

        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        String passwordCheck = passwordEncoder.encode(signupRequestDto.getPasswordCheck());


        if (!signupRequestDto.getPassword().equals(signupRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException( "패스워드가 일치하지 않습니다.");
        }

        User user = new User(email,password,username);
        userRepository.save(user);
        return "저장완료";

    }
}
