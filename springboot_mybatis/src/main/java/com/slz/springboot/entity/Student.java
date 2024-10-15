package com.slz.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("学生信息")
public class Student {
    @ApiModelProperty("学生id")
    private Integer id;
    @ApiModelProperty("学生姓名")
    private String name;
    @ApiModelProperty("学生性别")
    private String gender;
    @ApiModelProperty("学生年龄")
    private Integer age;
}
