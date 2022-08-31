package com.cjc.user_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient  value: 服务提供者的应用名称
@FeignClient(value = "order-service")
public interface OrderFeign {

//    被调用服务的controller 接口的签名
    @GetMapping("addOrder")
    public String addOrder();

}
