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

        // Find user OR throw exception
        UserAccount user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Attach user + timestamp
        event.setUser(user);
        event.setTimestamp(LocalDateTime.now());

        // Save event
        LoginEvent saved = loginRepo.save(event);

        // Run policy check
        ruleEvaluator.evaluateLoginEvent(saved);

        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long id) {
        UserAccount user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return loginRepo.findByUser(user);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long id) {
        UserAccount user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return loginRepo.findByUserAndLoginStatus(user, "FAILED");
    }
}







// package com.example.demo.service.impl;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.LoginEventRepository;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.LoginEventService;
// import com.example.demo.util.RuleEvaluationUtil;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class LoginEventServiceImpl implements LoginEventService {

//     private final LoginEventRepository loginRepo;
//     private final UserAccountRepository userRepo;
//     private final RuleEvaluationUtil ruleEvaluator;

//     @Override
//     public LoginEvent recordLogin(LoginEvent event) {
//         LoginEvent saved = loginRepo.save(event);       // Save event first
//         ruleEvaluator.evaluateLoginEvent(saved);        // Trigger violation check
//         return saved;
//     }

//     @Override
//     public List<LoginEvent> getEventsByUser(Long userId) {
//         UserAccount user = userRepo.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
//         return loginRepo.findByUser(user);
//     }

//     @Override
//     public List<LoginEvent> getSuspiciousLogins(Long userId) {
//         UserAccount user = userRepo.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
//         return loginRepo.findByUserAndLoginStatus(user, "FAILED");
//     }
// }
