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
    private final UserAccountRepository userRepository;
    private final RuleEvaluationUtil ruleEvaluator;

    @Override
    public LoginEvent recordLogin(Long userId, LoginEvent event) {

        UserAccount user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        event.setUser(user);
        event.setTimestamp(LocalDateTime.now());

        LoginEvent saved = loginRepo.save(event);
        ruleEvaluator.evaluateLoginEvent(saved);

        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return loginRepo.findByUser_Id(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return loginRepo.findByUser_IdAndLoginStatus(userId, "FAILED");
    }
}




// package com.example.demo.service.impl;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.repository.LoginEventRepository;
// import com.example.demo.service.LoginEventService;
// import com.example.demo.util.RuleEvaluationUtil;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @RequiredArgsConstructor
// public class LoginEventServiceImpl implements LoginEventService {

//     private final LoginEventRepository loginRepo;
//     private final RuleEvaluationUtil ruleEvaluator;

//     @Override
//     public LoginEvent recordLogin(LoginEvent event) {
//         LoginEvent saved = loginRepo.save(event);
//         ruleEvaluator.evaluateLoginEvent(saved);   // triggers violations
//         return saved;
//     }

//     @Override
//     public List<LoginEvent> getEventsByUser(Long id) {
//         return loginRepo.findByUserId(id);
//     }

//     @Override
//     public List<LoginEvent> getSuspiciousLogins(Long id) {
//         return loginRepo.findByUserIdAndLoginStatus(id, "FAILED");
//     }
// }
