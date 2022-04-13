package com.xzx.service;

import com.xzx.dao.CourseDao;
import com.xzx.pojo.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService{

    private final CourseDao courseMapper;

    public CourseServiceImpl(CourseDao courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public boolean delete(int id) {
        return courseMapper.delete(id);
    }

    @Override
    public boolean update(Course course) {
        return courseMapper.update(course);
    }



    @Override
    public List<Course> findAll(int page) {
        int offset=(page-1)*PAGE_SIZE;
        return courseMapper.findAll(offset);
    }

    @Override
    public Course findByName(String name) {
        return this.courseMapper.findByName(name);
    }

    @Override
    public Course findByID(int id) {
        return courseMapper.findByID(id);
    }

    @Override
    public boolean insert(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public List<Course> findByName_obscure(String name){
        return courseMapper.findByName_obscure(name);
    }
}
