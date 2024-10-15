package com.slz.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.slz.springboot.entity.Student;
import com.slz.springboot.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@RestController
@RequestMapping("/stu")
@Api(tags = "学生信息")
public class StudentController {
    @Resource
    private StudentService studentService;

    @ApiOperation("查询所有学生信息")
    @GetMapping("/all")
    public Object show() {
        return studentService.selectAll();
    }

    @ApiOperation("添加学生信息")
    @PostMapping ("/add")
    public Object add(@RequestBody Student student) {
        return studentService.insert(student);
    }
    @ApiOperation("分页查询")
    @GetMapping("/page/{start}/{size}")
    public Object page(@PathVariable Integer start, @PathVariable Integer size) {
        // 开启分页查询
        PageHelper.startPage(start, size);
        List<Student> students = studentService.selectAll();
        // 封装分页信息
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
}
