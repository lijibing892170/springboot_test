package com.ljb.test.config;

import com.ljb.test.model.BaseResponce;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

//@Configuration
public class RouterFunctionConfig {

    /**
     * flux
     * */
//    @Bean
//    public RouterFunction<ServerResponse> login() {
//        return RouterFunctions.route(RequestPredicates.GET("/login"),
//                request -> {
//                    String path = request.path();
//
//                    System.out.println("path:" + path);
//                    return ServerResponse.ok().body(new BaseResponce(true, "hello word"));
//                });
//    }
}
