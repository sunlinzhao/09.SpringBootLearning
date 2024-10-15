package com.slz.springboot.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Data
@Component // 作为 spring 组件，能够被扫描到
@ConfigurationProperties(prefix = "com.slz.springboot.model.users")
public class Users {
//    @Value("${com.slz.springboot.model.users.name}")
    private String userName;
//    @Value("${com.slz.springboot.model.users.gender}")
    private String gender;
//    @Value("${com.slz.springboot.model.users.age}")
    private Integer age;
//    @Value("${com.slz.springboot.model.users.money}")
    private Double money;
//    @Value("${com.slz.springboot.model.users.birthday}")
    private LocalDate birthday;
}
