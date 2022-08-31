package com.cjc.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 陈境聪
 * @date 2022年08月29日 16:03
 */

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/addOrder")
    public String addOrder(String token) {
       return "下单成功！"+token;
    }
}