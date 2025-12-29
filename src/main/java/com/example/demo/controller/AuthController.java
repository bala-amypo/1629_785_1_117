package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAccountRepository userRepo;
    private final AuthenticationManager authManager;
    private final JwtUtil jwt;
    private final PasswordEncoder encoder;

    @PostMapping("/register") // Create user first
    public UserAccount register(@RequestBody UserAccount user){
        user.setPassword(encoder.encode(user.getPassword()));   // encode password
        return userRepo.save(user);
    }

    @PostMapping("/login") // Real login
    public Map<String,String> login(@RequestBody Map<String,String> body){

        String email = body.get("email");
        String password = body.get("password");

        // Authenticate user using Spring Security
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        // Generate token
        UserAccount u = userRepo.findByEmail(email).get();
        String token = jwt.generateToken(u.getUsername(),u.getId(),u.getEmail(),u.getRole());

        return Map.of("token", token);
    }
}





