package com.example.simplelogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("pass").roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/login","/logout","/h2-console/**","/css/**").permitAll().anyRequest()
				.authenticated()).formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/form", true).permitAll()).logout(logout -> logout.permitAll());
		
		http.csrf(csrf -> csrf.disable())
		.headers(headers -> headers.frameOptions().sameOrigin());
		/*
		 * http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
		 * .headers(headers -> headers.frameOptions().sameOrigin());
		 */
		
		return http.build();
	}
	}

