package com.slz.springboot.service;

import com.slz.springboot.dao.UserDao;
import com.slz.springboot.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Override
    public List<Users> selectAll() {
        return userDao.selectAll();
    }
}
