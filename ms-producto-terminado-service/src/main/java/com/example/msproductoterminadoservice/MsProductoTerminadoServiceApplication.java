package com.example.msproductoterminadoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsProductoTerminadoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProductoTerminadoServiceApplication.class, args);
    }

}
