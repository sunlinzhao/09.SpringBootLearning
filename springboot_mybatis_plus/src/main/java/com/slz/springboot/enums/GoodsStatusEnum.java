package com.slz.springboot.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/14
 */
public enum GoodsStatusEnum {
    IN(0, "入库"),
    OUT(1, "出库");

    @EnumValue
    private final Integer code;
    private final String desc;

    GoodsStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    // 重写 toString() 方法，查询时返回描述，而非 0 1
    @Override
    public String toString() {
        return desc;
    }
}
