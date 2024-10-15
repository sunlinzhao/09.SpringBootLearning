package com.slz.springboot.service;

import com.slz.springboot.entity.Team;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */
public interface TeamService {
    int insert(Team team);
    List<Team> selectAll();
}
