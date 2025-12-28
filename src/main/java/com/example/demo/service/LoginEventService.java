package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {
    LoginEvent recordLogin(Long userId, LoginEvent event);   // <--- 2 args
    List<LoginEvent> getEventsByUser(Long id);
    List<LoginEvent> getSuspiciousLogins(Long id);
}











// package com.example.demo.service;

// import com.example.demo.entity.LoginEvent;
// import java.util.List;

// public interface LoginEventService {
//     LoginEvent recordLogin(LoginEvent event);
//     List<LoginEvent> getEventsByUser(Long id);
//     List<LoginEvent> getSuspiciousLogins(Long id);
// }