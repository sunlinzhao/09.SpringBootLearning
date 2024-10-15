package com.slz.springboot.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.slz.springboot.enums.GoodsStatusEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/11
 */
@Data
@TableName("goods")
public class Goods {
    private String id;
    private String name;
    private Double price;
    @TableField(value = "createTime", fill = FieldFill.INSERT) // 插入时填充字段
    private LocalDateTime createTime; // 创建时间
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE) // 插入和更新时填充字段
    private LocalDateTime updateTime; // 修改时间
    private Integer del; // 逻辑删除标志
    private GoodsStatusEnum status; // 商品状态
}
