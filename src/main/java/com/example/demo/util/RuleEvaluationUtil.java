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

        List<PolicyRule> rules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {

            if (event.getLoginStatus() != null &&
                rule.getConditionsJson() != null &&
                event.getLoginStatus().contains(rule.getConditionsJson())) {

                ViolationRecord vr = new ViolationRecord();
                vr.setEvent(event);                   // ← Change here
                vr.setUser(event.getUser());         // ← Change here
                vr.setTimestamp(LocalDateTime.now());
                vr.setSeverity(rule.getSeverity());
                vr.setDetails("Rule violated: " + rule.getConditionsJson());

                violationRepo.save(vr);
            }
        }
    }
}
