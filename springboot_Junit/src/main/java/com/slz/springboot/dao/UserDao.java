package com.slz.springboot.dao;

import com.slz.springboot.entity.Users;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
public interface UserDao {
    List<Users> selectAll();
}
