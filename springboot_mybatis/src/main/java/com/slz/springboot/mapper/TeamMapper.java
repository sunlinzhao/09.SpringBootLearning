package com.slz.springboot.mapper;

import com.slz.springboot.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */
@Repository
public interface TeamMapper {
    int insert(Team team);
    List<Team> selectAll();
}
