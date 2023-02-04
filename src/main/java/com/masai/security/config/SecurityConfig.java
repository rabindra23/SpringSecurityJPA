package com.masai.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	protected SecurityFilterChain mySecurityConfig(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((auth)->auth
				.requestMatchers("/api/admin/","/api/secure/user").authenticated()
				.requestMatchers("/api/user").permitAll()
		).httpBasic();
		return http.build();	
	}
	
	@Bean
	 protected PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance(); //Not recommended
	}
}
