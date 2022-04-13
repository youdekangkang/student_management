package com.xzx.dao;



import com.xzx.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDao {

    // about offset, let service lawyer to do it.
    @Select("select * from course order by `name` limit #{offset},5")
    List<Course> findAll(int offset);

    @Select("select * from course order by `name` where name like concat('%',#{name},'%')")
    List<Course> findByName_obscure(String name);


    @Select("select * from course order by `name` where name=#{name}")
    Course findByName(String name);
    @Select("select * from course order by `name` where id=#{id}")
    Course findByID(int id);

    @Insert("insert into course(`name`,`hours`,`description`,`syllabus`,`teacher`) values(#{name},#{hours},#{description},#{syllabus},#{teacher})")
    boolean insert(Course course);

    @Delete("delete from course where id=#{id}")
    boolean delete(int id);

    @Update("update course set name=#{name},hours=#{hours},description=#{description},syllabus=#{syllabus},teacher=#{teacher} where id=#{id}")
    boolean update(Course course);
}
