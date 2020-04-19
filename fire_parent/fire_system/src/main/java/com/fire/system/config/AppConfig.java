package com.fire.system.config;

import com.fire.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xu.dm
 * @Date: 2020/4/17 11:46
 * @Version: 1.0
 * @Description: TODO
 **/
@Configuration
public class AppConfig {
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
