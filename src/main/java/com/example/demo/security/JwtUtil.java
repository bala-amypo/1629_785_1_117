package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "TestSecretKeyForJWT1234567890"; // Do not change
    private final long expiry = 3600000; // 1 hour

    public String generateToken(String username, Long userId, String email, String role) {
        return Jwts.builder()
                .claim("uid", userId)
                .claim("email", email)
                .claim("role", role)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String getEmail(String token) { return (String) getClaims(token).get("email"); }
    public String getRole(String token) { return (String) getClaims(token).get("role"); }
    public Long getUserId(String token) { return Long.valueOf(getClaims(token).get("uid").toString()); }
}
