package com.example.ecommerceApp.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
        @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); // Allow Angular
        config.setAllowedMethods(Collections.singletonList("*")); // Allow all methods (GET, POST, PUT, DELETE, etc.)
        config.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


}
