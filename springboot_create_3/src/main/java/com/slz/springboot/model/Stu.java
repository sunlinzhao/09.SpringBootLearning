package com.slz.springboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Data
@Component
public class Stu {
    private String name;
    private Integer age;
}
