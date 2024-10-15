package com.slz.springboot.dao;

import com.slz.springboot.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public List<Users> selectAll() {
        List<Users> list = new ArrayList<>();
        list.add(new Users("1", "张三", "男", 22));
        list.add(new Users("2", "李四", "女", 23));
        list.add(new Users("3", "王五", "男", 24));
        return list;
    }
}
