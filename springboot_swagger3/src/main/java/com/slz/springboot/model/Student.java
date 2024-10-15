package com.slz.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学生信息", description = "学生信息")
public class Student {
    @ApiModelProperty(value = "学生id", required = true, example = "12")
    private Integer id;
    @ApiModelProperty(value = "学生姓名", required = true, example = "张三")
    private String name;
    @ApiModelProperty(value = "学生性别", required = true, example = "男")
    private String gender;
    @ApiModelProperty(value = "学生年龄", required = true, example = "18")
    private Integer age;
}
