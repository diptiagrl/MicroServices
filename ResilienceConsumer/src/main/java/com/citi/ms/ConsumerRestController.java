package com.citi.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class ConsumerRestController {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/greet")
	@CircuitBreaker(name="producer", fallbackMethod = "fallbackMethod")
	public String messageFromProducer()
	{
		return template.getForObject("http://REST-PRODUCER/hello", String.class);
	}
	
	public String fallbackMethod(RuntimeException runtimeException)
	{
		return "Something went wrong, pleasr tryy later";
	}
}
