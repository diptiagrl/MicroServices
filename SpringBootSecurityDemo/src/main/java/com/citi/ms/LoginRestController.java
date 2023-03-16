package com.citi.ms;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

	@GetMapping("/auth")
	public String login(Principal p)
	{
		return "SUCCESS "+p.getName();
	}
	
	@GetMapping("/hello")
	public String helloMessage()
	{
		return "HELLO THERE";
	}
}
