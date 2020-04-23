package com.fire.company.config;

import com.fire.common.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author: xu.dm
 * @Date: 2020/4/22 11:06
 * @Version: 1.0
 * @Description: TODO
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
                .excludePathPatterns("/favicon.ico","/login","/actuator/**");

    }
}
