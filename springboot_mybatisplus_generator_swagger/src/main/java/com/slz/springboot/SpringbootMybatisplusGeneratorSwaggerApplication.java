package com.slz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SpringbootMybatisplusGeneratorSwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusGeneratorSwaggerApplication.class, args);
    }

}
