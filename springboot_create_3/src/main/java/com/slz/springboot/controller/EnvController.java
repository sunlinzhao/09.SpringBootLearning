package com.slz.springboot.controller;

import org.springframework.core.env.Environment;
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
@RequestMapping("/env")
public class EnvController {
    @Resource
    private Environment env;
    @GetMapping
    public String show() {
        return env.getProperty("sysUser") + "\n"
                + env.getProperty("age") + "\n"
                + env.getProperty("money") + "\n"
                + env.getProperty("birthday") + "\n"
                + env.getProperty("com.slz.springboot.model.users.name") + "\n"
                + env.getProperty("com.slz.springboot.model.users.gender");
    }
}
