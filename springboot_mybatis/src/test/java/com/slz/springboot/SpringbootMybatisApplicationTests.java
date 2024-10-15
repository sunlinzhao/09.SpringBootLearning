package com.slz.springboot;

import com.slz.springboot.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Resource
    private StudentService studentService;

    @Test
    void contextLoads() {
        studentService.selectAll().forEach(System.out::println);
    }

}
