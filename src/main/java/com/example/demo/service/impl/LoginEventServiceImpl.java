// package com.example.demo.service.impl;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.repository.LoginEventRepository;
// import com.example.demo.service.LoginEventService;
// import com.example.demo.util.RuleEvaluationUtil;

// import java.util.List;
// import org.springframework.stereotype.Service;
// @Service
// public class LoginEventServiceImpl implements LoginEventService {

//     private LoginEventRepository repo;
//     private RuleEvaluationUtil evaluator;

//     public LoginEventServiceImpl(LoginEventRepository repo,
//                                  RuleEvaluationUtil evaluator) {
//         this.repo = repo;
//         this.evaluator = evaluator;
//     }
//   @Override
//     public LoginEvent recordLogin(LoginEvent e) {
//         LoginEvent saved = repo.save(e);
//         evaluator.evaluateLoginEvent(e);
//         return saved;
//     }
//   @Override
//     public List<LoginEvent> getEventsByUser(Long id) {
//         return repo.findByUserId(id);
//     }
//   @Override
//     public List<LoginEvent> getSuspiciousLogins(Long id) {
//         return repo.findByUserIdAndLoginStatus(id, "FAILED");
//     }
//   @Override
//     public List<LoginEvent> getAllEvents() {
//         return repo.findAll();
//     }
// }


// // package com.example.demo.service.impl;

// // import com.example.demo.entity.LoginEvent;
// // import com.example.demo.repository.LoginEventRepository;
// // import com.example.demo.service.LoginEventService;
// // import com.example.demo.util.RuleEvaluationUtil;

// // import java.util.List;
// // import org.springframework.stereotype.Service;

// // @Service
// // public class LoginEventServiceImpl implements LoginEventService {

// //     private final LoginEventRepository loginRepo;
// //     private final RuleEvaluationUtil ruleEvaluator;

// //     public LoginEventServiceImpl(LoginEventRepository loginRepo,
// //                                  RuleEvaluationUtil ruleEvaluator) {
// //         this.loginRepo = loginRepo;
// //         this.ruleEvaluator = ruleEvaluator;
// //     }

// //     @Override
// //     public LoginEvent recordLogin(LoginEvent event) {
// //         LoginEvent saved = loginRepo.save(event);
// //         ruleEvaluator.evaluateLoginEvent(event);
// //         return saved;
// //     }

// //     @Override
// //     public List<LoginEvent> getEventsByUser(Long userId) {
// //         return loginRepo.findByUserId(userId);
// //     }

// //     @Override
// //     public List<LoginEvent> getSuspiciousLogins(Long userId) {
// //         return loginRepo.findByUserIdAndLoginStatus(userId, "FAILED");
// //     }

// //     @Override
// //     public List<LoginEvent> getAllEvents() {
// //         return loginRepo.findAll();
// //     }
// // }


package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class LoginEventServiceImpl implements LoginEventService {
    private final LoginEventRepository repo;
    private final Object evaluator;

    public LoginEventServiceImpl(LoginEventRepository repo, Object evaluator) {
        this.repo = repo;
        this.evaluator = evaluator;
    }
    public LoginEvent recordLogin(LoginEvent e) { return repo.save(e); }
    public List<LoginEvent> getEventsByUser(Long id) { return repo.findByUserId(id); }
    public List<LoginEvent> getSuspiciousLogins(Long id) {
        return repo.findByUserIdAndLoginStatus(id, "FAILED");
    }
}
