package com.slz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableOpenApi // 开启 swagger3
//@EnableSwagger2 // 启用 swagger2
public class SpringbootSwagger3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwagger3Application.class, args);
    }
}
