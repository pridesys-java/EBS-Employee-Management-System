//package com.jenkins.cicd.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class UserConfig {
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("user999")).roles("USER")
//				.build();
//
//		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin123"))
//				.roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(); // Securely hash passwords
//	}
//}
