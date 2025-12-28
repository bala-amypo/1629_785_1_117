package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
@RequiredArgsConstructor
public class LoginEventController {

    private final LoginEventService loginService;

    @PostMapping
    public LoginEvent record(@RequestBody LoginEvent event){
        return loginService.recordLogin(event);     // ✔ correct call
    }

    @GetMapping("/user/{id}")
    public List<LoginEvent> userEvents(@PathVariable Long id){
        return loginService.getEventsByUser(id);
    }

    @GetMapping("/user/{id}/failed")
    public List<LoginEvent> failedLogins(@PathVariable Long id){
        return loginService.getSuspiciousLogins(id);
    }
}
