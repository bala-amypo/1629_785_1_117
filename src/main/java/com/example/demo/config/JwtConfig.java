package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {
        // ✅ Must match constructor expected in tests
        return new JwtUtil(
                "TestSecretKeyForJWT1234567890",
                3600000L,
                true
        );
    }
}
