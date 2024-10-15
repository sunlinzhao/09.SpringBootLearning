package com.slz.redis.controller;

import com.slz.redis.service.ParamsService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/15
 */
@RestController
@RequestMapping("params")
public class ParamsController {
    @Resource
    private ParamsService paramsService;
    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/{id}")
    public Object selectById(@PathVariable Long id) {
        String key = "params: " + id;
        Object o = redisTemplate.opsForValue().get(key);
        if (o != null) {
            System.out.println("从缓存获取\n" + "key: " + key + "\nvalue: " + o);
            // 从缓存获取
            return o;
        } else {
            // 从数据库获取
            Object params = paramsService.getById(id);
            // 存入缓存
            redisTemplate.opsForValue().set(key, params);
            // 设置过期时间
            redisTemplate.expire(key, 60, TimeUnit.SECONDS);
            System.out.println("【从数据库获取】\n" + "key: " + key + "\nvalue: " + params);
            return params;
        }
    }
}
