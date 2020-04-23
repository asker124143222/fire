package com.fire.system.client;

import com.fire.entity.company.CoCompany;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: xu.dm
 * @Date: 2020/4/23 10:53
 * @Version: 1.0
 * @Description: 通过Feign实现微服务间调用
 **/
@FeignClient("fire-company")
public interface CompanyFeignClient {

    @GetMapping("/company")
    List<CoCompany> selectAll();
}
