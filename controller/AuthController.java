package com.miniproject2.miniproject2.controller;


import com.miniproject2.miniproject2.dto.JwtAuthResponse;
import com.miniproject2.miniproject2.dto.LoginDto;
import com.miniproject2.miniproject2.dto.RegisterDto;
import com.miniproject2.miniproject2.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("api/auth")
public class AuthController {
    AuthService authService;
    //End Points to register User
    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto){
        String registermessage=authService.register(registerDto);
        return registermessage;
    }
    //Login Controller to get Login detail and Process it
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        JwtAuthResponse jwtAuthResponse =authService.login(loginDto);
        return new ResponseEntity<>(jwtAuthResponse,HttpStatus.OK);
    }
}
