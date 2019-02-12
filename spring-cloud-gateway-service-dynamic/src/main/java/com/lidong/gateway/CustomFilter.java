package com.lidong.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

/**
 * @Auther: lidong
 * @Date: 2019-01-31 13:57
 * @Description:
 */
@Configuration
public class CustomFilter {
    private final static Logger logger = LoggerFactory.getLogger(CustomFilter.class.getSimpleName());

    @Bean
    @Order(-1)
    public GlobalFilter requestLogFilter() {
        return (exchange, chain) -> {
            logger.info("first pre filter:" + exchange.getRequest().getURI());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("third post filter finish");
            }));
        };
    }

}