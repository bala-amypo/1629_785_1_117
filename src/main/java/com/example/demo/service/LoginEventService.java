// package com.example.demo.service;

// import com.example.demo.entity.LoginEvent;
// import java.util.List;

// public interface LoginEventService {
//     void logLoginEvent(LoginEvent event);          
//     LoginEvent getLoginEventById(Long id);        
//     List<LoginEvent> getAllLoginEvents();         
//     List<LoginEvent> getLoginEventsByUserId(Long userId); 
// }

package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {

    LoginEvent recordLogin(LoginEvent event);

    List<LoginEvent> getEventsByUser(Long userId);

    List<LoginEvent> getSuspiciousLogins(Long userId);

    List<LoginEvent> getAllEvents();
}
