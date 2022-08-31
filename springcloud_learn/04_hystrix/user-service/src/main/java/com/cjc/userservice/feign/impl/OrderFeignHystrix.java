package com.cjc.userservice.feign.impl;

import com.cjc.userservice.feign.OrderFeign;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

/**
 * @author 陈境聪
 * @date 2022年08月25日 17:38
 */

/*
* Hystrix类直接实现Feign接口
* */
@Component
public class OrderFeignHystrix  implements OrderFeign {


    /*
    * feign调用服务不可用时，执行的后备方法
    * */
    @Override
    public String addOrder() {
        System.out.println("调用下单服务失败，我走 hystrix 了");
        return "网络异常，请稍后重新下单。";
    }
}
