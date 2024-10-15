package com.slz.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/11
 */
@Data
@TableName("xhids")
public class XueHuaId {
    private Long id;
    private LocalDate time;
}
