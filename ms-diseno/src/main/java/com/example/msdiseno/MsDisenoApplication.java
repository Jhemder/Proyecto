package com.example.msdiseno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsDisenoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsDisenoApplication.class, args);
	}
}
