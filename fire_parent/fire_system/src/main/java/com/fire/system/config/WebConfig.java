package com.fire.system.config;

import com.fire.common.interceptor.JwtInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author: xu.dm
 * @Date: 2020/4/22 11:06
 * @Version: 1.0
 * @Description: 这里不继承WebMvcConfigurationSupport，而是实现WebMvcConfigurer，主要原因是：
 * 前者会导致传到前端的json时间格式失效，统一变成timestamp。
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jwtInterceptor)
                //拦截所有url
                .addPathPatterns("/**")
                //排除登录url
                .excludePathPatterns("/favicon.ico","/login","/actuator/info","/heartbeat");

    }
}
