package com.xzx.service;

import com.xzx.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

public interface CourseService {

    public final int PAGE_SIZE=5;

    List<Course> findAll(int page);

    List<Course> findByName_obscure(String name);

    Course findByName(String name);

    Course findByID(int id);

    boolean insert(Course course);

    boolean delete(int id);

    boolean update(Course course);
}
