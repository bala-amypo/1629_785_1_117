package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class UserAccountController {

    private final UserAccountService userService;

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserAccount> getAll(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}/status/{status}")
    public UserAccount updateStatus(@PathVariable Long id,@PathVariable String status){
        return userService.updateUserStatus(id,status);
    }
}
