package com.slz.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slz.springboot.entity.User;
import com.slz.springboot.mapper.UserMapper;
import com.slz.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
