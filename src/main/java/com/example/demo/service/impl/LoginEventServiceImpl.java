package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository) {
        this.loginEventRepository = loginEventRepository;
    }

    @Override
    public LoginEvent logLoginEvent(LoginEvent event) {
        return loginEventRepository.save(event);
    }

    @Override
    public LoginEvent getLoginEventById(Long id) {
        return loginEventRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Login event not found"));
    }

    @Override
    public List<LoginEvent> getAllLoginEvents() {
        return loginEventRepository.findAll();
    }

    @Override
    public List<LoginEvent> getLoginEventsByUserId(Long userId) {
        List<LoginEvent> events = loginEventRepository.findByUserId(userId);

        if (events.isEmpty()) {
            throw new ResourceNotFoundException("No login events found for user");
        }
        return events;
    }
}
