package com.example.educational_courses_catalog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.dao.CourseDao;
import com.example.educational_courses_catalog.dao.UserDao;
import com.example.educational_courses_catalog.entity.Course;
import com.example.educational_courses_catalog.entity.User;
import com.example.educational_courses_catalog.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserDao userDao;

    private void findTeacherName(Course course){
        String teacherId = course.getTeacher();
        User user = userDao.findById((long) Integer.parseInt(teacherId));
        course.setTeacher(user.getUsername());
    }

    @Transactional
    @Override
    public Result findAll(int current) {
        IPage<Course> page = courseDao.findAll(current);
        List<Course> courses = page.getRecords();
        for (Course course : courses) {
            findTeacherName(course);
        }
        return Result.success(String.valueOf(page.getPages()), courses);
    }

    @Transactional
    @Override
    public Result findByTeacherId(int current, Long id) {
        IPage<Course> page = courseDao.findByTeacherId(current, id);
        List<Course> courses = page.getRecords();
        for (Course course : courses) {
            findTeacherName(course);
        }
        return Result.success(String.valueOf(page.getPages()), courses);
    }

    @Transactional
    @Override
    public Result findByName(String name, int current) {
        IPage<Course> page = courseDao.findByName(name, current);
        List<Course> courses = page.getRecords();
        for (Course course : courses) {
            findTeacherName(course);
        }
        return Result.success(String.valueOf(page.getPages()), courses);
    }

    @Transactional
    @Override
    public Result findById(Long id) {
        Course course = courseDao.findById(id);
        findTeacherName(course);
        return Result.success("success",course);
    }

    @Transactional
    @Override
    public Result insert(Course course) {
        boolean insert = courseDao.insert(course);
        return insert ? Result.success("insert successfully")
                : Result.error("insert failed");
    }

    @Transactional
    @Override
    public Result delete(Long id) {
        boolean delete = courseDao.delete(id);
        return delete ? Result.success("delete successfully")
                : Result.error("delete failed");
    }

    @Transactional
    @Override
    public Result update(Course course) {
        boolean update = courseDao.update(course);
        return update ? Result.success("update successfully")
                : Result.error("update failed");
    }
}
