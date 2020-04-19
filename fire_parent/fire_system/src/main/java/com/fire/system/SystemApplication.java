package com.fire.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: xu.dm
 * @Date: 2020/4/18 22:17
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.fire")
@MapperScan("com.fire.system.dao")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
