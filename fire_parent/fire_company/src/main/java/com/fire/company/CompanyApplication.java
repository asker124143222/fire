package com.fire.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: xu.dm
 * @Date: 2020/4/17 10:46
 * @Version: 1.0
 * @Description: TODO
 * 配置springboot的包扫描scanBasePackages = "com.fire" 是为了通用模块里的公共异常等类可以被扫描到。
 **/

@SpringBootApplication(scanBasePackages = "com.fire")
@MapperScan("com.fire.company.dao")
@EnableEurekaClient
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }
}
