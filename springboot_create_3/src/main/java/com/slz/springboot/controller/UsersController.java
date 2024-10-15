package com.slz.springboot.controller;

import com.slz.springboot.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */

@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource // 属性注入
    private Users users;
    @GetMapping
    public Object show() {
        return users;
    }
}
