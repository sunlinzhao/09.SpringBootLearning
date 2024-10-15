package com.slz.springboot.mapper;
import org.apache.ibatis.annotations.Param;

import com.slz.springboot.entity.Params;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2024-10-15
 */
@Mapper
public interface ParamsMapper extends BaseMapper<Params> {
    int insertSelective(Params params);
}
