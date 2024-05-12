package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/ms-one/**")
                        .filters(f -> f.rewritePath("/ms-one/(?<segment>.*)", "/${segment}")
                                        .addResponseHeader("sss-source", "ms-one"))
                        .uri("lb://ms-one"))

                .route(p -> p.path("/ms-two/**")
                        .filters(f -> f.rewritePath("/ms-two/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("sss-source", "ms-two")
						)
                        .uri("lb://ms-two"))
                .build();
    }

}
