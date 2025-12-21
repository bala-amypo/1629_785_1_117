package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}/status")
    public UserAccount updateStatus(@PathVariable Long id,@RequestParam String status) {
        return service.updateUserStatus(id, status);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return service.getAllUsers();
    }
}
