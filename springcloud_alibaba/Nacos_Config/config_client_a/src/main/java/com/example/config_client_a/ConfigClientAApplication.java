package com.example.config_client_a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAApplication.class, args);
	}

}
