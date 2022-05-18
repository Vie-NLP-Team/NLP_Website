package com.opinion.viopinion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.opinion.viopinion.dao")
@SpringBootApplication
public class ViopinionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViopinionApplication.class, args);
    }

}
