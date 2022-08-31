package com.example.config_client_a.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 陈境聪
 * @date 2022年08月31日 9:19
 */

@RestController
@RefreshScope
public class UserController {

    @Value("${user.id}")
    private Integer id;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    @GetMapping("/getUser")
    public String getConfigUser() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
