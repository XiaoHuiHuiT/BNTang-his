package com.it6666;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BNTang
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/8/28 14:43
 * @description 统计模块启动类
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.it6666.mapper"})
@EnableDubbo
public class StatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
    }
}