package com.example.docgen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.docgen.entities.enums.UserRole;
import com.example.docgen.services.UserService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

	@SuppressWarnings("unused")
	private final UserService userService;

	public SecurityConfig(UserService userService) {
		this.userService = userService;

	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().hasRole(UserRole.ADMIN.name()) // 🔓
		// Permitir
		// apenas
		// admin

		).httpBasic(withDefaults());

		return http.build();
	}
}
