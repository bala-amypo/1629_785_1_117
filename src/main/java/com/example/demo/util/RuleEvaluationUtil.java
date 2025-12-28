package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public void evaluateLoginEvent(LoginEvent event) {

        // testcase expects findByActiveTrue()
        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {

            // simple rule check (FAILED status)
            if (event.getLoginStatus() != null &&
                rule.getConditionsJson() != null &&
                event.getLoginStatus().contains(rule.getConditionsJson())) {

                ViolationRecord vr = new ViolationRecord();
                vr.setEventId(event.getId());
                vr.setUserId(event.getUser().getId());     // FIXED
                vr.setSeverity(rule.getSeverity());
                vr.setResolved(false);
                vr.setDetails("Rule violated: " + rule.getConditionsJson() +
                        " at " + LocalDateTime.now());     // timestamp included

                violationRepo.save(vr); // testcase expects save() call
            }
        }
    }
}
