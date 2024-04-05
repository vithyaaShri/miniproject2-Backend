package com.miniproject2.miniproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//For Change Password
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 public class PasswordRequestUtil {
        private  String username;
        private String oldPassword;
        private String newPassword;
 }

