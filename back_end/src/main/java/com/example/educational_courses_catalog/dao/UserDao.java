package com.example.educational_courses_catalog.dao;

import com.example.educational_courses_catalog.entity.User;

import java.util.List;

public interface UserDao {

    User findById(Long id);

    User findByName(String username);

    boolean update(String username, String password);

    boolean update(User user);

    boolean insert(User user);

    List<User> findAll();

    List<User> findAllTeacher();

    boolean delete(String username);
}
