package com.example.spingboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.spingboot.dao")
@SpringBootApplication
public class SpingbootApplication {
    

    public static void main(String[] args) {
        SpringApplication.run(SpingbootApplication.class, args);
    }

}
