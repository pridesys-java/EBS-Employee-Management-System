//package com.jenkins.cicd.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
//		http
//		.csrf(csrf -> csrf.disable())
//		.authorizeHttpRequests(auth -> auth
//				.requestMatchers("/api/deparment/**").permitAll()
//				.requestMatchers("/api/admin/**").hasRole("ADMIN")
//				.anyRequest().authenticated())
//		
//		.formLogin(form -> form
//				.loginProcessingUrl("/logins")
//				.defaultSuccessUrl("/api/admin/home", true)
//				.permitAll()
//		)
//		.logout(logout -> logout
//				.logoutUrl("/logout")
//				.permitAll()
//		)
//		;
//		return http.build();
//	}
//
//}
