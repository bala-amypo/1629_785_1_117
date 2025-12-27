// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserAccountService userService;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public UserAccount register(@RequestBody RegisterRequest request) {

//         UserAccount user = new UserAccount();
//         user.setUsername(request.getUsername());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());

//         return userService.createUser(user);
//     }

//     @PostMapping("/login")
//     public JwtResponse login(@RequestBody LoginRequest request) {

//         String token = jwtUtil.generateToken(
//                 request.getUsername(), 1L, "test@test.com", "USER");

//         return new JwtResponse(token);
//     }
// }
