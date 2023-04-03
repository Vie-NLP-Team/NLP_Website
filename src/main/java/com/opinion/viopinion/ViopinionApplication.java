package com.opinion.viopinion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJdbcRepositories("com.opinion.viopinion.repository")
@EnableJpaRepositories("com.opinion.viopinion.repository")
@EntityScan("com.opinion.viopinion.entity")
@SpringBootApplication
public class ViopinionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViopinionApplication.class, args);
    }
}
