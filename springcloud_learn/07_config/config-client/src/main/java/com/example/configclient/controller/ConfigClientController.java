package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈境聪
 * @date 2022年08月30日 10:51
 */

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${user.name}")
    private String userName;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return userName;
    }
}
