package com.vaibhav.portfolio.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (if needed)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/experiences", "/projects").permitAll() // Allow access to /experiences
                        .anyRequest().authenticated() // Require authentication for other endpoints
                )
                .build();
    }
}
