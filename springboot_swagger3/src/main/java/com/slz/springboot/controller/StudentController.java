package com.slz.springboot.controller;

import com.slz.springboot.model.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/8
 */
@RestController
@RequestMapping("/stu")
@Api(tags = "学生信息管理") // 用在类上, 表示对类的说明, tags 说明该类的作用;
public class StudentController {
    @PostMapping()
    @ApiOperation("添加学生信息")
    public Object add(@RequestBody Student student) {
        return student;
    }
    @GetMapping()
    @ApiOperation("查询学生列表") // 用在方法上，说明方法用途和作用
    public Object list() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(null, "小明", "男", 18));
        list.add(new Student(null, "小红", "女", 19));
        list.add(new Student(null, "小刚", "男", 20));
        list.add(new Student(null, "陈维", "男", 27));
        return list;
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询学生信息")
    @ApiImplicitParams(
            @ApiImplicitParam(
                    name = "id",
                    value = "学生id",
                    required = true,
                    dataType = "Integer",
                    dataTypeClass = Integer.class,
                    paramType = "path" // paramType 表示参数类型, 包括：path, query, body, header, form
            )
    )
    public Object selectById(@PathVariable Integer id) {
        return new Student(id, "小明", "男", 18);
    }

    @GetMapping("/selectByName")
    @ApiOperation("根据姓名查询学生信息")
    public Object selectByName(@ApiParam(name = "name", value = "学生姓名", required = true) @RequestParam String name) {
        return new Student(null, name, "男", 18);
    }
}
