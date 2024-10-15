package com.slz.springboot.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.slz.springboot.entity.Params;
import com.slz.springboot.service.IParamsService;
import com.slz.springboot.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author slz
 * @since 2024-10-15
 */
@RestController
@RequestMapping("/springboot/params")
@Api(tags = "参数管理")
public class ParamsController {
    @Resource
    private IParamsService paramsService;

    @GetMapping("/list")
    @ApiOperation("查询参数列表")
    public Result list() {
        List<Params> list = paramsService.list();
        return Result.success().setData("list", list);
    }

    @PostMapping("/add")
    @ApiOperation("添加参数")
    public Result add(@RequestBody Params params) {
        return paramsService.save(params) ? Result.success() : Result.error();
    }
    @PutMapping("/update")
    @ApiOperation("修改参数")
    public Result update(@RequestBody Params params) {
        return paramsService.updateById(params) ? Result.success() : Result.error();
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除参数")
    public Result delete(@PathVariable Long id) {
        return paramsService.removeById(id) ? Result.success() : Result.error();
    }
    @GetMapping("/get/{id}")
    @ApiOperation("查询参数")
    public Result get(@PathVariable Long id) {
        return Result.success().setData("params", paramsService.getById(id));
    }

    @GetMapping("/{start}/{size}")
    @ApiOperation("分页查询参数")
    public Result selectPage(@PathVariable Integer start, @PathVariable Integer size) {
        Page<Params> page = new Page<>(start, size);
        paramsService.page(page);
        return Result.success().setData("page", page);
    }
}
