// package com.example.demo.service.impl;

// import com.example.demo.entity.PolicyRule;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.service.PolicyRuleService;

// import java.util.List;

// import org.springframework.stereotype.Service;
// @Service
// public class PolicyRuleServiceImpl implements PolicyRuleService {

//     private PolicyRuleRepository repo;

//     public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
//         this.repo = repo;
//     }
//   @Override
//     public PolicyRule createRule(PolicyRule r) {
//         return repo.save(r);
//     }
//   @Override
//     public PolicyRule updateRule(Long id, PolicyRule r) {
//         PolicyRule p = repo.findById(id).orElseThrow();
//         p.setDescription(r.getDescription());
//         p.setSeverity(r.getSeverity());
//         p.setConditionsJson(r.getConditionsJson());
//         p.setActive(r.getActive());
//         return repo.save(p);
//     }
//   @Override
//     public List<PolicyRule> getActiveRules() {
//         return repo.findByActiveTrue();
//     }
//   @Override
//     public PolicyRule getRuleByCode(String code) {
//         return repo.findByRuleCode(code).orElseThrow();
//     }
//   @Override
//     public List<PolicyRule> getAllRules() {
//         return repo.findAll();
//     }
// }



// // package com.example.demo.service.impl;

// // import com.example.demo.entity.PolicyRule;
// // import com.example.demo.repository.PolicyRuleRepository;
// // import com.example.demo.service.PolicyRuleService;

// // import java.util.List;
// // import org.springframework.stereotype.Service;

// // @Service

// // public class PolicyRuleServiceImpl implements PolicyRuleService {

// //     private final PolicyRuleRepository ruleRepo;

// //     public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
// //         this.ruleRepo = ruleRepo;
// //     }

// //     @Override
// //     public PolicyRule createRule(PolicyRule rule) {
// //         return ruleRepo.save(rule);
// //     }

// //     @Override
// //     public PolicyRule updateRule(Long id, PolicyRule rule) {
// //         PolicyRule existing = ruleRepo.findById(id).orElseThrow();
// //         existing.setDescription(rule.getDescription());
// //         existing.setSeverity(rule.getSeverity());
// //         existing.setConditionsJson(rule.getConditionsJson());
// //         existing.setActive(rule.getActive());
// //         return ruleRepo.save(existing);
// //     }

// //     @Override
// //     public List<PolicyRule> getActiveRules() {
// //         return ruleRepo.findByActiveTrue();
// //     }

// //     @Override
// //     public PolicyRule getRuleByCode(String ruleCode) {
// //         return ruleRepo.findByRuleCode(ruleCode).orElseThrow();
// //     }

// //     @Override
// //     public List<PolicyRule> getAllRules() {
// //         return ruleRepo.findAll();
// //     }
// // }

package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class PolicyRuleServiceImpl implements PolicyRuleService {
    private final PolicyRuleRepository repo;
    public PolicyRuleServiceImpl(PolicyRuleRepository repo) { this.repo = repo; }

    public PolicyRule createRule(PolicyRule r) { return repo.save(r); }
    public List<PolicyRule> getActiveRules() { return repo.findByActiveTrue(); }
    public List<PolicyRule> getAllRules() { return repo.findAll(); }
}
