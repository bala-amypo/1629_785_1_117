// package com.example.demo.service;

// import com.example.demo.entity.LoginEvent;
// import java.util.*;

// public interface LoginEventService {
//     LoginEvent recordLogin(LoginEvent event);
//     List<LoginEvent> getEventsByUser(Long userId);
//     List<LoginEvent> getSuspiciousLogins(Long userId);
//     List<LoginEvent> getAllEvents();
// }
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;
public interface LoginEventService {
    LoginEvent recordLogin(LoginEvent e);
    List<LoginEvent> getEventsByUser(Long id);
    List<LoginEvent> getSuspiciousLogins(Long id);
}