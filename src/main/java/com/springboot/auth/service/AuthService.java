package com.springboot.auth.service;

import com.springboot.auth.payload.RegisterDto;

public interface AuthService {


    String register(RegisterDto registerDto);
}
