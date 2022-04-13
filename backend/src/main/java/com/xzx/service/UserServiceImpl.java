package com.xzx.service;

import com.xzx.dao.UserDao;
import com.xzx.pojo.User;

public class UserServiceImpl implements UserService{

    private final UserDao userMapper;

    public UserServiceImpl(UserDao userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public User findByID(int id) {
        return userMapper.findByID(id);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }


    @Override
    public boolean insert(User user) {
        return userMapper.insert(user);
    }
}
