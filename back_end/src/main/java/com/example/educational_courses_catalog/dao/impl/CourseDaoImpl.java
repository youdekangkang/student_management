package com.example.educational_courses_catalog.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.educational_courses_catalog.dao.CourseDao;
import com.example.educational_courses_catalog.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {
    @Override
    public IPage<Course> findAll(int current) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("name");
        Page<Course> page = new Page<>(current, 10);
        return new Course().selectPage(page,wrapper);
    }

    @Override
    public IPage<Course> findByTeacherId(int current, Long id) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", id);
        Page<Course> page = new Page<>(current, 10);
        return new Course().selectPage(page,wrapper);
    }

    @Override
    public IPage<Course> findByName(String name,int current) {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name)
                .orderByDesc("name");
        Page<Course> page = new Page<>(current, 10);
        return new Course().selectPage(page,wrapper);
    }

    @Override
    public Course findById(Long id) {
        return new Course().selectById(id);
    }

    @Override
    public boolean insert(Course course) {
        return course.insert();
    }

    @Override
    public boolean delete(Long id) {
        return new Course().deleteById(id);
    }

    @Override
    public boolean update(Course course) {
        return course.updateById();
    }
}
