package com.xzx.controller;

import com.xzx.pojo.Course;
import com.xzx.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    @Qualifier("courseService")
    CourseService courseService;

    @GetMapping
    public String showAllCourses(Model model, HttpServletRequest request,int page){
//        System.out.println(request.getMethod());
        List<Course> allCourse = courseService.findAll(page);
        System.out.println(allCourse);
        model.addAttribute("list",allCourse);
        model.addAttribute("page",page);
        return "allCourse";
    }


    @DeleteMapping("/{ID}")
    public String delCourse(@PathVariable int ID){
//        System.out.println("收到对 "+ID+" 的删除请求");
        boolean delete = courseService.delete(ID);
        if(delete) System.out.println("del done!");
        else System.out.println("del fault");

        return "redirect:/course";
    }

    @PostMapping("/{ID}")
    public String toUpdateCourseJSP(@PathVariable int ID,Model model){
        Course course = courseService.findByID(ID);
        model.addAttribute("course",course);
        return "updateCourse";
    }

    @RequestMapping("/update")
    public String updateCourse(Course course){
        System.out.println(course);
        boolean update = courseService.update(course);
        if(update) System.out.println("update done!");
        else System.out.println("update fault");


        return "redirect:/course";
    }


    @PutMapping
    public String toAddCourseJSP(){
        return "addCourse";
    }

    @RequestMapping("/add")
    public String addCourse(Course course){
        boolean insert = courseService.insert(course);
        if (insert) System.out.println("insert done!");
        else System.out.println("insert fault");
        return "redirect:/course";
    }





//    @RequestMapping("/search")
//    public String searchCourse_obscure(String Name,Model model){
//        System.out.println("收到关于 "+Name+" 的查询请求");
//        List<Course> courses = courseService.findByName_obscure(Name);
//        model.addAttribute("list",courses);
//        return "allCourse";
//    }

    @GetMapping("/{Name}")
    public String searchCourse_obscure(@PathVariable String Name,Model model){
//        System.out.println("收到关于 "+Name+" 的查询请求");
        List<Course> courses = courseService.findByName_obscure(Name);
        model.addAttribute("list",courses);
        return "allCourse";
    }

}
