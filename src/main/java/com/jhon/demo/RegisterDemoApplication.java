package com.jhon.demo;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegisterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterDemoApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        //为了代码演示，不另起项目.
        return new IdWorker();
    }

}
