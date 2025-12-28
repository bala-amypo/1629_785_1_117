package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login-events")
@RequiredArgsConstructor
public class LoginEventController {

    private final LoginEventService loginEventService;

    @PostMapping
    public LoginEvent record(@RequestBody LoginEvent event) {
        Long userId = event.getUser().getId();  // extract userId from JSON
        return loginEventService.recordLogin(userId, event);
    }

    @GetMapping("/{userId}")
    public List<LoginEvent> getEvents(@PathVariable Long userId) {
        return loginEventService.getEventsByUser(userId);
    }

    @GetMapping("/{userId}/suspicious")
    public List<LoginEvent> getSuspicious(@PathVariable Long userId) {
        return loginEventService.getSuspiciousLogins(userId);
    }
}
