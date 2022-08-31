package com.example.nacosclienta.controller;

import com.example.nacosclienta.feign.TestFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 陈境聪
 * @date 2022年08月30日 16:12
 */

@RestController
public class ClientController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-provider}")
    private String serviceUrl;

    @Resource
    private TestFeign testFeign;

    @GetMapping("/client/echo/{string}")
    public String consumer(@PathVariable String string) {
        System.out.println("进来了");
        return restTemplate.getForObject(serviceUrl+"/echo/"+string,String.class);
    }

    @GetMapping("/echo/{string}")
    public String feign(@PathVariable String string) {
       return testFeign.echo(string);
    }
}
