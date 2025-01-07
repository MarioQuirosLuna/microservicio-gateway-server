package com.example.springcloud.app.gateway.filters;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("ejecutando el filtro antes del request PRE");

        ServerHttpRequest mutatedRequest = exchange.getRequest()
            .mutate()
            .header("token", "abcdefg")
            .build();

        ServerWebExchange mutatedExchange = exchange.mutate().request(mutatedRequest).build();

        return chain.filter(mutatedExchange).then(Mono.fromRunnable(() -> {
            logger.info("ejecutando filtro POST response");

            //OPCION 1: Agregar headers
            String token = mutatedExchange.getRequest().getHeaders().getFirst("token");
            if(token != null){
                logger.info("token 1: " + token);
                mutatedExchange.getResponse().getHeaders().add("token1", token);
            }

            //OPCION 2: Agregar headers
            Optional.ofNullable(mutatedExchange.getRequest().getHeaders().getFirst("token")).ifPresent(value -> {
                logger.info("token 2: " + value);
                mutatedExchange.getResponse().getHeaders().add("token2", value);
            });

            mutatedExchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "red").build());
            mutatedExchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
    }

    @Override
    public int getOrder() {
        return 100;
    }
    
}
