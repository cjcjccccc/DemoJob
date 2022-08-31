package com.cjc.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @author 陈境聪
 * @date 2022年08月29日 16:46
 */

@Component
class MyLogGateWayFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyLogGateWayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("———————进入MyLogGateWayFilter-------");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null) {
            LOGGER.info("请求没有认证");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        LOGGER.info("认证通过！");
        return chain.filter(exchange);
    }

    /*** order 越小 越先执行
     ** @return */
    @Override
    public int getOrder() {
        return 0;
    }
}
