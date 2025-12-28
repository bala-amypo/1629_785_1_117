package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/logins")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class LoginEventController {

    private final LoginEventService loginEventService;

    @PostMapping("/{userId}")     // Create login event for a user
    public LoginEvent record(@PathVariable Long userId,
                             @RequestBody LoginEvent event){
        return loginEventService.recordLogin(userId, event);
    }

    @GetMapping("/{userId}")      // Get all login events for user
    public List<LoginEvent> userEvents(@PathVariable Long userId){
        return loginEventService.getEventsByUser(userId);
    }

    @GetMapping("/{userId}/failed")  // Get suspicious (FAILED) logins
    public List<LoginEvent> suspicious(@PathVariable Long userId){
        return loginEventService.getSuspiciousLogins(userId);
    }
}
