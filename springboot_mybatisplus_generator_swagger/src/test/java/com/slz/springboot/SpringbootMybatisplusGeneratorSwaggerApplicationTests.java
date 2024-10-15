package com.slz.springboot;

import com.slz.springboot.entity.Params;
import com.slz.springboot.service.IParamsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootMybatisplusGeneratorSwaggerApplicationTests {
    @Resource
    private IParamsService paramsService;

    @Test
    void contextLoads() {
        paramsService.save(new Params().setCode(104).setName("手机代码"));
    }

}
