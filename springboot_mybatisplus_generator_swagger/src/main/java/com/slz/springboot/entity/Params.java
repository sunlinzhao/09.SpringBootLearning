package com.slz.springboot.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author slz
 * @since 2024-10-15
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_params")
@ApiModel(value = "Params对象", description = "")
public class Params implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Integer code;

    private String name;

    @TableLogic
    private Integer del;
    @Version
    private Integer version;


}
