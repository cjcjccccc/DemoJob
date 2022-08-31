package com.cjc.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;

/**
 * @author 陈境聪
 * @date 2022年08月29日 11:12
 */
@RestController
public class PaymentController {

    @GetMapping("/get/{id}")
    public String payId(@PathVariable("id") int id)  {
        return "订单号为：" + id;
    }

    @GetMapping("/get")
    @ResponseBody
    public String payId()  {
        return "请求成功";
    }
}
