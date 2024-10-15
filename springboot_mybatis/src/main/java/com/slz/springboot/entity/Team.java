package com.slz.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/10
 */
@ApiModel("球队信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @ApiModelProperty("球队id")
    private Integer id;
    @ApiModelProperty("球队名称")
    private String name;
}
