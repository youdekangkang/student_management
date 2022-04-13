package com.xzx.dao;


import com.xzx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {

    @Select("select * from user where username=#{username}")
    User findByName(String username);

    @Select("select * from user where id=#{id}")
    User findByID(int id);

    @Update("update user set username=#{username},password=#{password},role=#{role} where id=#{id}")
    boolean update(User user);

    @Insert("insert into user(`username`,`password`,`role`) values(#{username},#{password},#{role})")
    boolean insert(User user);
}
