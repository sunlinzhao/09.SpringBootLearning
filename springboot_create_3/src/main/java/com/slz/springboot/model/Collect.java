package com.slz.springboot.model;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = "collect")
public class Collect {
    private List<String> list1;
    private List<String> list2;
    private Set<String> set1;
    private Set<String> set2;
    private Map<String, String> map1;
    private Map<String, String> map2;
}

