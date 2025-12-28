package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class LoginEventController {

    private final LoginEventService loginEventService;

    @PostMapping
    public LoginEvent record(@RequestBody LoginEvent event) {
        return loginEventService.recordLogin(event);   // FIXED name
    }

    @GetMapping
    public List<LoginEvent> all() {
        return loginEventService.getEventsByUser(1L); // or adjust as needed
    }

    @GetMapping("/{userId}")
    public List<LoginEvent> getUserEvents(@PathVariable Long userId){
        return loginEventService.getEventsByUser(userId);
    }

    @GetMapping("/{userId}/failed")
    public List<LoginEvent> suspicious(@PathVariable Long userId){
        return loginEventService.getSuspiciousLogins(userId);
    }
}
