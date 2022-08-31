package com.example.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈境聪
 * @date 2022年08月30日 15:46
 */

@RestController
public class EchoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello,"+string+",from port="+port;
    }
}
