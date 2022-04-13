package com.example.educational_courses_catalog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.educational_courses_catalog.entity.Course;
import com.example.educational_courses_catalog.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserMapperTest {

    @Test
    public void testSelectById(){
        User user = new User();
        user.setId(1L);
        System.out.println(user.selectById());
    }

    @Test
    public void testSelectById2(){
        Course course = new Course();
        course.setId(1L);
        System.out.println(course.selectById());
    }

    @Test
    public void update() {
        User user = new User();
        user.setPassword("123");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "Lisa");
        user.update(wrapper);
    }

    @Test
    public void findByName() {
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "Lisa");
        System.out.println(user.selectOne(wrapper));
    }

}
