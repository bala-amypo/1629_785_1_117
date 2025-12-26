// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     // 🔐 FIXED secret key (NOT random)
//     private static final String SECRET_KEY =
//             "mysecretkeymysecretkeymysecretkeymysecretkey";

//     private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//     }

//     public String generateToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .claim("userId", userId)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(getSigningKey())
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String extractEmail(String token) {
//         return extractAllClaims(token).get("email", String.class);
//     }

//     public String extractRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     public Long extractUserId(String token) {
//         return extractAllClaims(token).get("userId", Long.class);
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtUtil {

    private String secret;
    private long expirationMillis;
    private boolean someFlag; // optional

    // Constructor to match your JwtConfig
    public JwtUtil(String secret, long expirationMillis, boolean someFlag) {
        this.secret = secret;
        this.expirationMillis = expirationMillis;
        this.someFlag = someFlag;
    }

    // generateToken method to match your AuthController
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
