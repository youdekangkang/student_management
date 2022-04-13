package com.example.educational_courses_catalog.controller;

import com.example.educational_courses_catalog.common.Result;
import com.example.educational_courses_catalog.vo.ChangePassword;
import com.example.educational_courses_catalog.vo.LoginInfo;
import com.example.educational_courses_catalog.entity.User;
import com.example.educational_courses_catalog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "user management")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("register")
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

    @ApiOperation("login")
    @PostMapping("/login")
    public Result login(@RequestBody LoginInfo loginInfo){
        return userService.login(loginInfo);
    }

    @ApiOperation("change password")
    @PutMapping("/changePassword")
    public Result changePassword(@RequestBody ChangePassword changePassword) {
        return userService.changePassword(changePassword);
    }

    @ApiOperation("get user's role")
    @GetMapping("/getRole/{name}")
    public Result getRole(@PathVariable String name){
        return userService.getRole(name);
    }

    @ApiOperation("delete")
    @DeleteMapping("/delete/{username}")
    public Result delete(@PathVariable String username){
        return userService.delete(username);
    }

    @ApiOperation("find all user")
    @GetMapping("/findAll")
    public Result findAll(){
        return userService.findAll();
    }

    @ApiOperation("find all teacher")
    @GetMapping("/findTeacher")
    public Result findAllTeacher(){
        return userService.findAllTeacher();
    }

    @ApiOperation("change identity by name")
    @PutMapping("/changeIdentity")
    public Result changeIdentity(@RequestParam String username){
        return userService.changeIdentity(username);
    }
}
