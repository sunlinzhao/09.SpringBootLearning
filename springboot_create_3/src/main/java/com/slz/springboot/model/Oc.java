package com.slz.springboot.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
@Data
@Component
@ConfigurationProperties(prefix = "oc")
public class Oc {
    private List<Stu> stus1;
    private List<Stu> stus2;
}
