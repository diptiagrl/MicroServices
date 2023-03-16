package com.citi.ms;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	// authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("shalini").password(encoder().encode("shalini"))
		.roles("USER")
		.and()
		.withUser("admin").password(encoder().encode("admin"))
		.roles("USER","ADMIN");
	}
	
	@Bean
	PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable().authorizeRequests()
		.antMatchers("/hello").permitAll()
		//.antMatchers("/auth").hasAnyRole("USER","ADMIN")
		.anyRequest()
		.authenticated().and().formLogin()
		.and().logout();
	}
	
}
