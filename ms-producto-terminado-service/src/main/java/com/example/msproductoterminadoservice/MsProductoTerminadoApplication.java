package com.example.msproductoterminadoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.msproductoterminadoservice.client")
public class MsProductoTerminadoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsProductoTerminadoApplication.class, args);
    }
}
