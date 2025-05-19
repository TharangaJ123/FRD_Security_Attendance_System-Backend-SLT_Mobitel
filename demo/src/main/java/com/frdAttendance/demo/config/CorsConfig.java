package com.frdAttendance.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // your React frontend origin
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true); // 🔑 This is required for sessions/cookies
    }
}
