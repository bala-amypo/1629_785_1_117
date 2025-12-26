// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;
// import org.springframework.http.ResponseEntity;
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
//     public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest req) {
//         UserAccount u = new UserAccount();
//         u.setEmployeeId(req.getEmployeeId());
//         u.setUsername(req.getUsername());
//         u.setEmail(req.getEmail());
//         u.setPassword(req.getPassword());
//         u.setRole(req.getRole());

//         return ResponseEntity.ok(userService.createUser(u));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
//         UserAccount user = userService.findByUsername(req.getUsername())
//                 .orElseThrow();

//         String token = jwtUtil.generateToken(
//                 user.getUsername(),
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );

//         return ResponseEntity.ok(
//                 new JwtResponse(token, user.getId(), user.getEmail(), user.getRole())
//         );
//     }
// }
@PostMapping("/login")
public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
    UserAccount user = userService.findByUsername(req.getUsername())
            .orElseThrow();

    // Only 3 params: userId, username, role
    String token = jwtUtil.generateToken(
            user.getId(),
            user.getUsername(),
            user.getRole()
    );

    return ResponseEntity.ok(
            new JwtResponse(token, user.getId(), user.getEmail(), user.getRole())
    );
}
