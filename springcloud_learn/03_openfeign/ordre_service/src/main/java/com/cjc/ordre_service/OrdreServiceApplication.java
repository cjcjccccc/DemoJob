package com.cjc.ordre_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrdreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdreServiceApplication.class, args);
	}

}
