package com.example.educational_courses_catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan("com.example.educational_courses_catalog.filter")
public class EducationalCoursesCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationalCoursesCatalogApplication.class, args);
    }

}
