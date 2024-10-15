package com.slz.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("team")
public class Team {
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableLogic
    private int del;
}
