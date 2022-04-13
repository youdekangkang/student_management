package com.example.educational_courses_catalog.controller;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.entity.Course;
import com.example.educational_courses_catalog.service.CourseService;
import com.example.educational_courses_catalog.service.DownloadService;
import com.example.educational_courses_catalog.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Api(tags = "course management")
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private DownloadService downloadService;

    @ApiOperation("find all courses")
    @GetMapping("/findAll")
    public Result findAll(@RequestParam int current){
        return courseService.findAll(current);
    }

    @ApiOperation("find courses by id")
    @GetMapping("/findByTeacherId/{id}")
    public Result findByTeacherId(@RequestParam int current,  @PathVariable Long id){
        return courseService.findByTeacherId(current, id);
    }

    @ApiOperation("find courses by name")
    @GetMapping("/findByName/{name}")
    public Result findByName(@PathVariable String name,@RequestParam int current){
        return courseService.findByName(name, current);
    }

    @ApiOperation("add")
    @PostMapping("/add")
    public Result add(@RequestBody Course course){
        return courseService.insert(course);
    }

    @ApiOperation("delete")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        return courseService.delete(id);
    }

    @ApiOperation("update")
    @PutMapping("/update")
    public Result update(@RequestBody Course course){
        return courseService.update(course);
    }

    @ApiOperation("upload")
    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile syllabus){
        return uploadService.upload(syllabus);
    }

    @ApiOperation("download syllabus")
    @GetMapping("/download/{id}")
    public void download(@PathVariable Long id, HttpServletResponse response) throws UnsupportedEncodingException {
        downloadService.download(id, response);
    }
}

















