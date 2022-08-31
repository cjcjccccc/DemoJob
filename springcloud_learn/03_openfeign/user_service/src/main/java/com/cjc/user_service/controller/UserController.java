package com.cjc.user_service.controller;

import com.cjc.user_service.feign.OrderFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 陈境聪
 * @date 2022年08月25日 15:39
 */

@RestController
public class UserController {


//    注入openfeign接口
    @Resource
    OrderFeign orderFeign;

    @GetMapping("addOrder")
    public String addOrder() {
        String s = orderFeign.addOrder();
        System.out.println(s);
        return s;
    }
}
