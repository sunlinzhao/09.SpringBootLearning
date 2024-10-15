package com.slz.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/15
 */
@RestController
@RequestMapping
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;
//    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/{key}")
    public Object get(@PathVariable String key){
        Object o = redisTemplate.opsForValue().get(key);
        return o;
    }
    @PostMapping ("/{key}/{val}")
    public Object set(@PathVariable String key, @PathVariable String val){
        redisTemplate.opsForValue().set(key,val);
        return "ok";
    }
}
