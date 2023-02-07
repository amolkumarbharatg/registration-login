package com.springboot.auth.service.impl;

import com.springboot.auth.entity.User;
import com.springboot.auth.exception.BlogAPIException;
import com.springboot.auth.payload.RegisterDto;
import com.springboot.auth.repository.UserRepository;
import com.springboot.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String register(RegisterDto registerDto) {
        // add check for username exists in database
        if(userRepository.existsByMobile(registerDto.getMobile())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setMobile(registerDto.getMobile());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());

       userRepository.save(user);

        return "User registered successfully!.";
    }
}
