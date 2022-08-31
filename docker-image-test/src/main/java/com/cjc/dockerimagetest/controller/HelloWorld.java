package com.cjc.dockerimagetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈境聪
 * @date 2022年08月31日 16:11
 */

@RestController
public class HelloWorld {


    @GetMapping("/hello")
    public String helloImages() {
        return "hello images!";
    }

}
