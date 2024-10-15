package com.slz.springboot;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;
import java.util.Collections;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/14
 */
@SpringBootTest
public class SpringTest {
    @Test
    void testGenerator() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("slz") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(".\\src\\main\\java") // 指定输出目录
                            .enableSwagger() // 开启 swagger 模式
                    ;
                })
                .packageConfig(builder ->
                        builder.parent("com.slz") // 设置父包名
                                .moduleName("springboot") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, ".\\src\\resources\\mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("sys_params") // 设置需要生成的表名
                                .addTablePrefix("sys_", "c_") // 设置过滤表前缀
                )
                .strategyConfig(builder -> builder.entityBuilder()
                        .entityBuilder().enableLombok() // 开启lombok模式
                        .versionColumnName("version") // 指定乐观锁字段名
                        .logicDeleteColumnName("del") // 指定逻辑删除字段名
                        .enableChainModel() // 开启链式调用
                )
                .strategyConfig(builder -> builder.controllerBuilder()
                        .enableRestStyle() // 开启restController
                )
                .strategyConfig(builder -> builder.mapperBuilder()
                        .enableMapperAnnotation() // 开启mapper注解
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
