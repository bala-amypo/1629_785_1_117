package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private PolicyRuleRepository ruleRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule rule) {
        PolicyRule existing = ruleRepo.findById(id).orElseThrow(() -> new BadRequestException("Rule not found"));
        existing.setDescription(rule.getDescription());
        existing.setSeverity(rule.getSeverity());
        existing.setConditionsJson(rule.getConditionsJson());
        existing.setActive(rule.getActive());
        return ruleRepo.save(existing);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public PolicyRule getRuleByCode(String ruleCode) {
        return ruleRepo.findByRuleCode(ruleCode).orElseThrow(() -> new BadRequestException("Rule not found"));
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
