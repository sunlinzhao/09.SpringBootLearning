package com.slz.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/14
 */
@Data
@TableName("user")
public class User extends Model<User> {
    private Long id;
    private String name;
    private Integer age;
    @Version
    @TableField(value = "version")
    private Integer version;
}
