package com.midea.saximanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.midea.saximanager.dao")
public class SaximanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaximanagerApplication.class, args);
    }

}
