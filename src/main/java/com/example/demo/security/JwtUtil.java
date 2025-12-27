// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import java.util.Date;

// public class JwtUtil {

//     private final String secret;
//     private final long validity;
//     private final boolean testMode;

//     public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
//         this.secret = secret;
//         this.validity = validityInMs;
//         this.testMode = isTestMode;
//     }

//     public String generateToken(String username, Long userId, String email, String role) {
//         return Jwts.builder()
//                 .claim("userId", userId)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setSubject(username)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + validity))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getEmail(String token) {
//         return getClaims(token).get("email", String.class);
//     }

//     public String getRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     public Long getUserId(String token) {
//         return getClaims(token).get("userId", Long.class);
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parser().setSigningKey(secret)
//                 .parseClaimsJws(token).getBody();
//     }
// }


//-----------------------//
package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;
    private final boolean isTestMode;

    public JwtUtil(String secret, long validityInMs, boolean isTestMode) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.isTestMode = isTestMode;
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username, Long userId, String email, String role) {
        return Jwts.builder()
                .claim("username", username)
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
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

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }

    public String getRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long getUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }
}
