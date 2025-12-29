package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {
    LoginEvent recordLogin(Long userId, LoginEvent event);   // FIXED ✔
    List<LoginEvent> getEventsByUser(Long id);
    List<LoginEvent> getSuspiciousLogins(Long id);
}
















// package com.example.demo.service;

// import com.example.demo.entity.*;
// import java.util.*;
// public interface LoginEventService {
//     LoginEvent recordLogin(LoginEvent e);
//     List<LoginEvent> getEventsByUser(Long id);
//     List<LoginEvent> getSuspiciousLogins(Long id);
// }
