package com.example.educational_courses_catalog.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.educational_courses_catalog.dao.UserDao;
import com.example.educational_courses_catalog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User findById(Long id){
        return new User().selectById(id);
    }

    @Override
    public User findByName(String username) {
        return new User().selectOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public boolean update(String username, String password) {
        User user = findByName(username);
        user.setPassword(password);
        return user.update(new UpdateWrapper<User>().eq("username", username));
    }

    @Override
    public boolean update(User user) {
        return user.updateById();
    }

    @Override
    public boolean insert(User user) {
        return user.insert();
    }

    @Override
    public List<User> findAll() {
        return new User().selectAll();
    }

    @Override
    public List<User> findAllTeacher() {
        return new User().selectList(new QueryWrapper<User>().eq("role", "teacher"));
    }

    @Override
    public boolean delete(String username) {
        return new User().delete(new QueryWrapper<User>().eq("username", username));
    }
}
