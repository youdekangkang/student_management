package com.example.educational_courses_catalog.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.educational_courses_catalog.entity.Course;

public interface CourseDao {
    IPage<Course> findAll(int current);

    IPage<Course> findByTeacherId(int current, Long id);

    IPage<Course> findByName(String name, int current);

    boolean insert(Course course);

    boolean delete(Long id);

    boolean update(Course course);

    Course findById(Long id);
}
