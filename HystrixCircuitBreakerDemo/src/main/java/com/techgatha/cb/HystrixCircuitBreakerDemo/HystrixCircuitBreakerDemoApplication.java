package com.techgatha.cb.HystrixCircuitBreakerDemo;

import com.techgatha.cb.HystrixCircuitBreakerDemo.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixCircuitBreakerDemoApplication {

	//https://github.com/Netflix/Hystrix/wiki/Configuration
	
	//http://localhost:8001/hystrix
	// http://localhost:8001/actuator/hystrix.stream
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(HystrixCircuitBreakerDemoApplication.class, args);
		MyService myService = ctx.getBean(MyService.class);

		System.out.println("-- calling doSomething(1) 40 times --");
		Thread.sleep(3000);
		int n = 40;
		for (int i = 0; i < n; i++) {
			System.out.println("******* "+i +" **************");
			if(i > 4)
				myService.doSomething(i < (n * 0.6) ? 0 : 2);// 10/0
			
			else
				 myService.doSomething(1);// 10/0
			TimeUnit.MILLISECONDS.sleep(100);
		}
		TimeUnit.SECONDS.sleep(2);

		System.out.println("-- final call --");
		myService.doSomething(2);
	}

}
