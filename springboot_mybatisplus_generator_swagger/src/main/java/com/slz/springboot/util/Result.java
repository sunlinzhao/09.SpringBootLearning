package com.slz.springboot.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/15
 */
@Data
@Accessors(chain = true)
public class Result {
    private Boolean success;
    private Integer code;
    private String msg;
    private Map<String, Object> data;

    public static Result success(){
        return new Result().setSuccess(true)
                .setCode(ResultCode.SUCCESS)
                .setMsg("成功")
                .setData(new HashMap<>());
    }
    public static Result error(){
        return new Result().setSuccess(false)
                .setCode(ResultCode.ERROR)
                .setMsg("失败")
                .setData(new HashMap<>());
    }
    public Result setData(Map<String, Object> data){
        this.data = data;
        return this;
    }
    public Result setData(String key, Object value){
        this.data.put(key, value);
        return this;
    }
}
