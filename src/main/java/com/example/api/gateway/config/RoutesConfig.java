package com.example.api.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("userService", r -> r.path("/user/**")
                    .filters(f -> f.addRequestHeader("user-request", "user-request-header")
                    .addResponseHeader("user-response", "user-response-header"))
                    .uri("http://localhost:8081/")
                )
                .route("bookService", r -> r.path("/book/**")
                        .uri("http://localhost:8082/")
                )
                .build();
    }

}
