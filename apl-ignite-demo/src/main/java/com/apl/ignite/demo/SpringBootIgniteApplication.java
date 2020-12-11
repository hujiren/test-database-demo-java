package com.apl.ignite.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:22
 */
@EnableSwagger2
@SpringBootApplication(
 scanBasePackages = {
         "com.apl.ignite.demo"
         })
@MapperScan(basePackages = "com.apl.ignite.demo.mapper")
public class SpringBootIgniteApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootIgniteApplication.class, args);

    }
}
