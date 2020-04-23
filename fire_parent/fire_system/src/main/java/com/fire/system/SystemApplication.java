package com.fire.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: xu.dm
 * @Date: 2020/4/18 22:17
 * @Description:
 *  todo  从Spring Cloud Edgware开始，@EnableDiscoveryClient或@EnableEurekaClient 可省略。
 *       只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
 *      @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到服务。
 *     不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 */
@SpringBootApplication(scanBasePackages = "com.fire")
@MapperScan("com.fire.system.dao")
//@EnableEurekaClient
//@EnableDiscoveryClient
@EnableFeignClients
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
