package com.cjc.ordre_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈境聪
 * @date 2022年08月25日 15:30
 */

@RestController
public class OrderController {

    @GetMapping("addOrder")
    public String addOrder() {
        return "下单成功";
    }
}
