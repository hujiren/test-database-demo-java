package com.apl.mongodb.demo;

import com.spring4all.mongodb.EnableMongoPlus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hjr start
 * @date 2020/6/2 - 18:19
 */
@EnableMongoPlus
@EnableSwagger2
@SpringBootApplication
public class SpringBootMongoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMongoApplication.class, args);
    }
}
