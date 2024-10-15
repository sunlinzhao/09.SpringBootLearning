package com.slz.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String id;
    private String name;
    private String gender;
    private Integer age;
}
