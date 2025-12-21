package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@RestController
@RequestMapping("/api/login-events")
public class LoginEventController {

    private final LoginEventService loginEventService;

    public LoginEventController(LoginEventService loginEventService) {
        this.loginEventService = loginEventService;
    }

    @PostMapping
    public LoginEvent logLoginEvent(@RequestBody LoginEvent event) {
        return loginEventService.logLoginEvent(event);
    }

    @GetMapping("/{id}")
    public LoginEvent getLoginEventById(@PathVariable Long id) {
        return loginEventService.getLoginEventById(id);
    }

    @GetMapping
    public List<LoginEvent> getAllLoginEvents() {
        return loginEventService.getAllLoginEvents();
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getLoginEventsByUserId(@PathVariable Long userId) {
        return loginEventService.getLoginEventsByUserId(userId);
    }
}
