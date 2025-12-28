package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginRepo;
    private final UserAccountRepository userRepo;
    private final RuleEvaluationUtil ruleEvaluator;

    @Override
    public LoginEvent recordLogin(Long userId, LoginEvent event) {
        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        event.setUser(user);                      // attach user
        event.setTimestamp(LocalDateTime.now());  // ensure timestamp

        LoginEvent saved = loginRepo.save(event);
        ruleEvaluator.evaluateLoginEvent(saved);  // trigger rule check

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
