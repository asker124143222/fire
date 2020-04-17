package com.fire.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: xu.dm
 * @Date: 2020/4/17 10:46
 * @Version: 1.0
 * @Description: TODO
 **/
@SpringBootApplication
@MapperScan("com.fire.company.dao")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }
}
