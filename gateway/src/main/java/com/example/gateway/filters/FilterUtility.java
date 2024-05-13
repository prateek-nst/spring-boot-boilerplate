package com.example.gateway.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {
    public static String CORRELATION_ID = "ms-correlation-id";

    public String getCorrelationId(HttpHeaders headers) {
        if(headers.get(CORRELATION_ID) != null){
            List<String> reqHeaderList = headers.get(CORRELATION_ID);
            return reqHeaderList.stream().findFirst().get();
        } else {
            return null;
        }
    }

    private ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }
}
