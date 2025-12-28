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

    @PostMapping("/{userId}")     // <<< userId comes from URL
    public LoginEvent record(@PathVariable Long userId,
                             @RequestBody LoginEvent event){
        return loginEventService.recordLogin(userId, event);
    }

    @GetMapping("/{userId}")
    public List<LoginEvent> userEvents(@PathVariable Long userId){
        return loginEventService.getEventsByUser(userId);
    }

    @GetMapping("/{userId}/failed")
    public List<LoginEvent> suspicious(@PathVariable Long userId){
        return loginEventService.getSuspiciousLogins(userId);
    }
}


// @RestController
// @RequestMapping("/logins")
// @RequiredArgsConstructor
// @SecurityRequirement(name = "BearerAuth")   // 🔒 Lock appears now
// public class LoginEventController {

//     private final LoginEventService loginService;

//     @PostMapping
//     public LoginEvent record(@RequestBody LoginEvent event){
//         return loginService.recordLogin(event);
//     }

//     @GetMapping("/user/{id}")
//     public List<LoginEvent> userEvents(@PathVariable Long id){
//         return loginService.getEventsByUser(id);
//     }

//     @GetMapping("/user/{id}/failed")
//     public List<LoginEvent> failedLogins(@PathVariable Long id){
//         return loginService.getSuspiciousLogins(id);
//     }
// }
