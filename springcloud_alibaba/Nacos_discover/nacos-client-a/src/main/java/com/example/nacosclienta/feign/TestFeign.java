package com.example.nacosclienta.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider")
public interface TestFeign {

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string);
}
