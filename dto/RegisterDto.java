package com.miniproject2.miniproject2.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//For Registration Form
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String name;

    private  String username;

    private String password;

    private  String email;
}
