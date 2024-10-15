package com.slz.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${sysUser}")
    private String sysUser;
    @Value("${age}")
    private Integer age;
    @Value("${money}")
    private Double money;
    @Value("${birthday}")
    private Date birthday;
    @Value("${server.port}")
    private Integer port;
    @GetMapping
    public String show(){
        return sysUser + " : " + age + " : " + money + " : " + birthday + " : " + port;
    }
}
