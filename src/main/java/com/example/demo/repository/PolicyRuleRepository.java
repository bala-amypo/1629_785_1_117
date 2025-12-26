package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {
    List<PolicyRule> findByActiveTrue();
    Optional<PolicyRule> findByRuleCode(String ruleCode);
}
