package com.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages= {"com.example.**"})
@Slf4j
@EnableScheduling
@EnableSwagger2
public class HellospringbootApplication {

    public static void main(String[] args) {
        log.info("start:");
        SpringApplication.run(HellospringbootApplication.class, args);
    }

}
