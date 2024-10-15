package com.slz.springboot.service;

import com.slz.springboot.entity.Student;
import com.slz.springboot.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */

@Service
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }
}
