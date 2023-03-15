package com.citi.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerRestController {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/greet")
	@HystrixCommand(fallbackMethod = "fallback")
	public String messageFromProducer()
	{
		return template.getForObject("http://REST-PRODUCER/hello", String.class);
	}
	
	public String fallback()
	{
		return "Something went wrong, pleasr tryy later";
	}
}
