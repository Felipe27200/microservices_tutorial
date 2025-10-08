package com.programming.jzea.gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes
{
    @Bean
    public RouterFunction<ServerResponse> productServiceRoute()
    {
        /*
        * Here, we are using Functional Endpoints, that are basically
        * methods that take ServerRequests and return ServerResponse.
        * */
        return GatewayRouterFunctions
                .route("product_service") // Route ID
                .route( // Route definition
                    RequestPredicates.path("/api/products"), // Set the condition that must be true for the request to be routed
                    HandlerFunctions.http("http://localhost:8080") // Set the host to redirect the route
                )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute()
    {
        return GatewayRouterFunctions
                .route("order_service")
                .route(
                        RequestPredicates.path("/api/orders"),
                        HandlerFunctions.http("http://localhost:8081")
                )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute()
    {
        return GatewayRouterFunctions
                .route("inventory_service")
                .route(
                        RequestPredicates.path("/api/inventory"),
                        HandlerFunctions.http("http://localhost:8082")
                )
                .build();
    }
}
