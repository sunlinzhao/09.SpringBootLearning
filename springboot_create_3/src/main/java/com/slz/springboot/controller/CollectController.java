package com.slz.springboot.controller;

import com.slz.springboot.model.Collect;
import com.slz.springboot.model.Oc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Resource
    private Collect collect;
    @Resource private Oc oc;
    @GetMapping
    public Object show() {
        return collect;
    }
    @GetMapping("/oc")
    public Object showOc() {
        return oc;
    }
}
