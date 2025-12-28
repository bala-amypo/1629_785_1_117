package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/login-events")
@RequiredArgsConstructor
@SecurityRequirement(name="BearerAuth")
public class LoginEventController {

    private final LoginEventService loginEventService;

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event){
        return loginEventService.recordEvent(event);
    }

    @GetMapping("/all")
    public List<LoginEvent> all(){
        return loginEventService.getAllEvents();
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> eventsByUser(@PathVariable Long userId){
        return loginEventService.getEventsByUser(userId);
    }
}
