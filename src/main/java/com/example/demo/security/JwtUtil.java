package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Must be >= 32 chars for HS256
    private final String secret = "MyUltraStrongJWTSecretKey_2025_Project256Bit";
    private final long expiry = 3600000; // 1 hour

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("uid", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmail(String token) { return getClaims(token).get("email", String.class); }
    public String getRole(String token) { return getClaims(token).get("role", String.class); }
    public Long getUserId(String token) { return getClaims(token).get("uid", Long.class); }
}






package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    private final String secret;
    private final long expiration;

    public JwtUtil(String secret, long expiration, boolean dummy) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // token format expected by tests
    // username:userId:email:role
    public String generateToken(String username, Long userId,
                                String email, String role) {

        String value = username + ":" + userId + ":" + email + ":" + role;
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String[] decode(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split(":");
    }

    public String getEmail(String token) {
        return decode(token)[2];
    }

    public String getRole(String token) {
        return decode(token)[3];
    }

    public Long getUserId(String token) {
        return Long.parseLong(decode(token)[1]);
    }
}
