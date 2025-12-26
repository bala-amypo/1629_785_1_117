package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {

    private String secret;
    private long expirationMillis;
    private boolean someFlag; // as expected in the tests

    // ✅ Constructor that matches test expectations
    public JwtUtil(String secret, long expirationMillis, boolean someFlag) {
        this.secret = secret;
        this.expirationMillis = expirationMillis;
        this.someFlag = someFlag;
    }

    // ✅ generateToken method as expected in tests (4 params)
    public String generateToken(String username, Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("username", username)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
