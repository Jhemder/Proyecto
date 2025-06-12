package com.example.msalmacenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsAlmacenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAlmacenServiceApplication.class, args);
	}
}
