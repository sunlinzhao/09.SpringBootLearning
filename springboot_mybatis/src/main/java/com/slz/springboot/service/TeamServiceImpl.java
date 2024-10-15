package com.slz.springboot.service;

import com.slz.springboot.entity.Team;
import com.slz.springboot.mapper.TeamMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */
@Service
public class TeamServiceImpl implements TeamService{
    @Resource
    private TeamMapper teamMapper;
    @Override
    public int insert(Team team) {
        return teamMapper.insert(team);
    }

    @Override
    public List<Team> selectAll() {
        return teamMapper.selectAll();
    }
}
