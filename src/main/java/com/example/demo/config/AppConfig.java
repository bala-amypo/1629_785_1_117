package com.example.demo.config;

import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RuleEvaluationUtil ruleEvaluationUtil(
            PolicyRuleRepository ruleRepo,
            ViolationRecordRepository violationRepo
    ) {
        return new RuleEvaluationUtil(ruleRepo, violationRepo);
    }
}
