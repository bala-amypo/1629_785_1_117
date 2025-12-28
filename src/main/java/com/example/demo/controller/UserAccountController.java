package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")   // 🔐 lock visible in Swagger
public class UserAccountController {

    private final UserAccountService userService;

    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAll(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @PathVariable String status){
        return ResponseEntity.ok(userService.updateUserStatus(id,status));
    }
}
