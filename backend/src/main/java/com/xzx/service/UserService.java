package com.xzx.service;

import com.xzx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface UserService {

    User findByName(String username);


    User findByID(int id);


    boolean update(User user);

    boolean insert(User user);
}
