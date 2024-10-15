package com.slz.springboot.service;

import com.slz.springboot.entity.Student;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
public interface StudentService {
    List<Student> selectAll();
    int insert(Student student);
}
