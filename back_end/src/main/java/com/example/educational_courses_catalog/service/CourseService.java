package com.example.educational_courses_catalog.service;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.entity.Course;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {
    Result findAll(int current);

    Result findByName(String name, int current);

    Result insert(Course course);

    Result delete(Long id);

    Result update(Course course);

    Result findByTeacherId(int current, Long id);

    Result findById(Long id);
}
