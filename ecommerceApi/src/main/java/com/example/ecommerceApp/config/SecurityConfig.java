package com.example.ecommerceApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(HttpMethod.POST,"/users").permitAll()
                        .anyRequest().permitAll())// Allow all requests
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        ;
        return http.build();
    }
}
