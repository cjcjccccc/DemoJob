package com.cjc.userservice.feign;

import com.cjc.userservice.feign.impl.OrderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient  value: 服务提供者的应用名称     fallback:绑定hystrix实现服务熔断
@FeignClient(value = "order-service",fallback = OrderFeignHystrix.class)
public interface OrderFeign {

//    被调用服务的controller 接口的签名
    @GetMapping("addOrder")
    public String addOrder();

}
