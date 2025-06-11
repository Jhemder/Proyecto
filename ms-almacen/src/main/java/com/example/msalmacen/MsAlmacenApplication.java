package com.example.msalmacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsAlmacenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAlmacenApplication.class, args);
    }

}
