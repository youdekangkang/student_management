package com.example.educational_courses_catalog.service.impl;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.dao.UserDao;
import com.example.educational_courses_catalog.vo.ChangePassword;
import com.example.educational_courses_catalog.vo.LoginInfo;
import com.example.educational_courses_catalog.entity.User;
import com.example.educational_courses_catalog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Result login(LoginInfo loginInfo){
        User user = userDao.findByName(loginInfo.getUsername());
        if (user == null || !loginInfo.getPassword().equals(user.getPassword())){
            return Result.error("username or password is incorrect");
        }
        return Result.success("login successfully", user.getId());
    }

    @Transactional
    @Override
    public Result changePassword(ChangePassword changePassword) {
        User user = userDao.findByName(changePassword.getUsername());
        if (user == null || !changePassword.getOldPassword().equals(user.getPassword())){
            return Result.error("username or password is incorrect");
        }
        boolean update = userDao.update(changePassword.getUsername(), changePassword.getNewPassword());
        return update ? Result.success("password changed successfully")
                : Result.error("password changed failed");
    }

    @Transactional
    @Override
    public Result getRole(String username) {
        return Result.success("success", userDao.findByName(username).getRole());
    }

    @Transactional
    @Override
    public Result register(User user) {
        String username = user.getUsername();
        User user2 = userDao.findByName(username);
        if (user2 != null){
            return Result.error("username has been registered");
        }
        boolean insert = userDao.insert(user);
        return insert ? Result.success("register successfully")
                : Result.error("register failed");
    }

    @Override
    public Result findAll() {
        return Result.success("success", userDao.findAll());
    }

    @Override
    public Result findAllTeacher() {
        return Result.success("success", userDao.findAllTeacher());
    }

    @Override
    public Result delete(String username) {
        boolean delete = userDao.delete(username);
        return delete ? Result.success("delete successfully") : Result.error("delete failed");
    }

    @Override
    public Result changeIdentity(String username) {
        User user = userDao.findByName(username);
        String role = user.getRole();
        if ("admin". equals(role)) return Result.error("you can change administrator's identity ");
        user.setRole("student".equals(role) ? "teacher" : "student");
        userDao.update(user);
        return Result.success("change successfully");
    }
}
