package com.citi.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// 20 mins from now
@EnableEurekaClient
@SpringBootApplication
public class CurrencyExchangeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeMicroserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate template() {
		System.out.println("cretaing rest template");
		return new RestTemplate();
	}
}
