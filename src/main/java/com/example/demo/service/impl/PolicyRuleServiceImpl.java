package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository ruleRepo;

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return ruleRepo.findAll();
    }
}





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
