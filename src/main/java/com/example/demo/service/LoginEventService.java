package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {
    void logLoginEvent(LoginEvent event);          
    LoginEvent getLoginEventById(Long id);        
    List<LoginEvent> getAllLoginEvents();         
    List<LoginEvent> getLoginEventsByUserId(Long userId); 
}
