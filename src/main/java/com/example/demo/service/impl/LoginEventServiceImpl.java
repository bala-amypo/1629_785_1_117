package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final RuleEvaluationUtil ruleEvaluator;

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = loginRepo.save(event);
        ruleEvaluator.evaluateLoginEvent(saved);   // triggers violations
        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long id) {
        return loginRepo.findByUserId(id);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long id) {
        return loginRepo.findByUserIdAndLoginStatus(id, "FAILED");
    }
}
