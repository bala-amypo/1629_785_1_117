package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    // PasswordEncoder bean for UserAccountServiceImpl
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // JwtUtil bean
    @Bean
    public JwtUtil jwtUtil() {
        // secret, validityInMs, isTestMode
        return new JwtUtil("TestSecretKeyForJWT1234567890", 3600000L, true);
    }
}
