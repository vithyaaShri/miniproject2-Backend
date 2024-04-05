package com.miniproject2.miniproject2.service;


import com.miniproject2.miniproject2.dto.JwtAuthResponse;
import com.miniproject2.miniproject2.dto.LoginDto;
import com.miniproject2.miniproject2.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    JwtAuthResponse login(LoginDto loginDto);
}
