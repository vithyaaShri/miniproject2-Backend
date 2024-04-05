package com.miniproject2.miniproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//To Send JWTAuthResponse token and Role
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType="Bearer";
    private String role;
}
