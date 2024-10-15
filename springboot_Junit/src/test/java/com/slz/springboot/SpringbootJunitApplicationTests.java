package com.slz.springboot;

import com.slz.springboot.entity.Users;
import com.slz.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = SpringbootJunitApplication.class)
class SpringbootJunitApplicationTests {
    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        List<Users> users = userService.selectAll();
        users.forEach(System.out::println);
    }
    @Test
    void test() {
        System.out.println("hello world");
    }
}
