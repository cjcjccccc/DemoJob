package com.cjc.consumer.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 陈境聪
 * @date 2022年08月25日 11:19
 */

@RestController
public class ConsumerController {

    @Resource
    RestTemplate restTemplate;

    @Resource
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/testRibbon")
    public String testRibbon(String serverName) {
        System.out.println("-------");
        return restTemplate.getForObject("http://" + serverName + "/lb", String.class);
    }


    /*
    * ribbon 默认的负载算法： 轮询
    * */
    @GetMapping("/testRibbonRule")
    public String testRibbonRule(String serverName) {
        ServiceInstance choose = loadBalancerClient.choose(serverName);
        return choose.getHost()+":"+choose.getPort();
    }

}
