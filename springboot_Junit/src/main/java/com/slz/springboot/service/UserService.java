package com.slz.springboot.service;

import com.slz.springboot.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
public interface UserService {
    List<Users> selectAll();
}
