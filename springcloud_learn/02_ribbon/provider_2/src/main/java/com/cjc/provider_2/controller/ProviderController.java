package com.cjc.provider_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈境聪
 * @date 2022年08月25日 11:09
 */

@RestController
public class ProviderController {

    @GetMapping("/lb")
    public String hello() {
        return "Provider—2提供的服务";
    }
}
