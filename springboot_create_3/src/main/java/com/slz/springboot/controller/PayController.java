package com.slz.springboot.controller;

import com.slz.springboot.pay.Pay;
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
@RequestMapping("/pay")
public class PayController {
    @Resource
    private Pay pay;

    @GetMapping
    public String show() {
        return pay.pay();
    }
}
