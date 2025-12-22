package com.example.demo.security;

public class JwtUtil {

    private String secret;
    private long validityInMs;
    private boolean isTestMode;

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.isTestMode = isTestMode;
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return null;
    }

    public boolean validateToken(String token) {
        return false;
    }

    public String getEmail(String token) {
        return null;
    }

    public String getRole(String token) {
        return null;
    }

    public Long getUserId(String token) {
        return null;
    }
}

