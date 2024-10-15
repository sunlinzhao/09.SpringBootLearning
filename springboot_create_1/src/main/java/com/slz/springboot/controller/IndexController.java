package com.slz.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/9/30
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public Object index(){
        return "hello springboot";
    }
}
