package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.time.LocalDateTime;
import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {
            if (rule.getConditionsJson() != null &&
                event.getLoginStatus() != null &&
                rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(rule.getSeverity());
                v.setDetectedAt(LocalDateTime.now());
                v.setResolved(false);

                violationRepo.save(v);
            }
        }
    }
}
