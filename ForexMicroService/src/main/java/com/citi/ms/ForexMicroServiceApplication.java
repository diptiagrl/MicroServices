package com.citi.ms;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.citi.ms.entity.ExchangeValue;
import com.citi.ms.repo.ExchangevalueRepo;

@EnableEurekaClient

//@EnableDiscoveryClient
@SpringBootApplication
public class ForexMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexMicroServiceApplication.class, args);
	}

	
	@Autowired 
	private ExchangevalueRepo repo;
	@Bean
	public void addData()
	{
		System.out.println("add data");
		ExchangeValue v1 = new ExchangeValue(1, "USA", "INR", new BigDecimal(80.0));
		ExchangeValue v2 = new ExchangeValue(2, "USA", "SGD", new BigDecimal(60.0));
		ExchangeValue v3 = new ExchangeValue(3, "EUR", "INR", new BigDecimal(90.0));
		
		repo.save(v1);
		repo.save(v2);
		repo.save(v3);
	}
	
}
