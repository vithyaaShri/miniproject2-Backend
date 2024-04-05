package com.miniproject2.miniproject2.service;


import com.miniproject2.miniproject2.entity.UserSecurity;

public interface UserSecurityService {
    UserSecurity getUser(String name);

    boolean oldPasswordIsValid(UserSecurity userSecurity,String oldPassword);
    void changePassword(UserSecurity userSecurity, String newPassword);
}
