public class JwtUtil {

    private String secret = "TestSecretKeyForJWT1234567890";
    private long expirationMillis = 3600000L;

    public JwtUtil() {
        // no-arg constructor for Spring and tests
    }

    public String generateToken(Long userId, String username, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("username", username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
