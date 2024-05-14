package com.example.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity.authorizeExchange(authorizeExchangeSpec ->
            authorizeExchangeSpec
                    .pathMatchers("/ms-two/**").permitAll()
                    .pathMatchers("/ms-one/**").hasRole("ADMIN"));

        httpSecurity.csrf(csrfSpec -> csrfSpec.disable());
        return httpSecurity.build();
    }
}
