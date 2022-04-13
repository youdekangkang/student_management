package com.xzx;

import com.xzx.pojo.User;
import com.xzx.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_userService {
    @Test
    public void test_q(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User byID = userService.findByID(1);
        System.out.println(byID);

    }
}
