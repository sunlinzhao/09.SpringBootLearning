package com.slz.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slz.springboot.entity.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */
public interface TeamMapper extends BaseMapper<Team> {
    List<Team> selectCustom();
    Page<Team> selectCustomPage(@Param("page")Page<Team> page, @Param("name")String name);
}
