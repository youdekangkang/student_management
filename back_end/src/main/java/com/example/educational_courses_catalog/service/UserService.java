package com.example.educational_courses_catalog.service;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.vo.ChangePassword;
import com.example.educational_courses_catalog.vo.LoginInfo;
import com.example.educational_courses_catalog.entity.User;

public interface UserService {

    Result login(LoginInfo loginInfo);

    Result changePassword(ChangePassword changePassword);

    Result getRole(String username);

    Result register(User user);

    Result findAll();

    Result findAllTeacher();

    Result delete(String username);

    Result changeIdentity(String username);
}
