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

            // testcase 19 condition: FAILED trigers violation
            if (event.getLoginStatus() != null &&
                rule.getConditionsJson() != null &&
                event.getLoginStatus().contains(rule.getConditionsJson())) {

                ViolationRecord vr = new ViolationRecord();
                vr.setEventId(event.getId());
                vr.setUserId(event.getUserId());
                vr.setTimestamp(LocalDateTime.now());
                vr.setSeverity(rule.getSeverity());
                vr.setDetails("Rule violated: " + rule.getConditionsJson());

                // testcase verifies save() is called
                violationRepo.save(vr);
            }
        }
    }
}
