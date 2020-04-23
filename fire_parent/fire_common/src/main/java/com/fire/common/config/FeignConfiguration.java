package com.fire.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
public class FeignConfiguration {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //    配置feign拦截器，解决请求头问题
    @Bean
    public RequestInterceptor requestInterceptor() {
        //获取所有浏览器发送的请求属性，请求头赋值到feign
        return requestTemplate -> {
            //请求属性
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                //获取浏览器发起的请求头
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    while (headerNames.hasMoreElements()) {
                        String name = headerNames.nextElement(); //请求头名称 Authorization
                        String value = request.getHeader(name);//请求头数据 "Bearer b1dbb4cf-7de6-41e5-99e2-0e8b7e8fe6ee"
                        requestTemplate.header(name, value);
                        if ("authorization".equals(name))
                            logger.info("Feign 拦截转发,name:" + name + ",value:" + value);
                    }
                }
            }

        };
    }

//    @Override
//    public void apply(RequestTemplate template) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes != null) {
//            HttpServletRequest request = attributes.getRequest();
//            //获取浏览器发起的请求头
//            Enumeration<String> headerNames = request.getHeaderNames();
//            if (headerNames != null) {
//                while (headerNames.hasMoreElements()) {
//                    String name = headerNames.nextElement(); //请求头名称 Authorization
//                    String value = request.getHeader(name);//请求头数据 "Bearer b1dbb4cf-7de6-41e5-99e2-0e8b7e8fe6ee"
//                    template.header(name, value);
//                }
//            }
//        }
//    }
}
