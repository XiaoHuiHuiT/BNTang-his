package com.it6666;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program BNTang-his
 * @date Created in 2020/8/27 17:43
 * @description 进销存模块启动类
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.it6666.mapper"})
@EnableDubbo
public class ErpApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class,args);
    }
}