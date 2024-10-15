package com.slz.springboot.controller;

import com.slz.springboot.entity.Team;
import com.slz.springboot.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */

@RestController
@Api(tags = "球队信息")
@RequestMapping("/team")
public class TeamController {
    @Resource
    private TeamService teamService;
    @ApiOperation("添加球队信息")
    @PostMapping("/add")
    public Object add(@RequestBody Team team) {
        return teamService.insert(team);
    }
    @ApiOperation("查询所有球队信息")
    @GetMapping("/all")
    public Object selectAll() {
        return teamService.selectAll();
    }
}
