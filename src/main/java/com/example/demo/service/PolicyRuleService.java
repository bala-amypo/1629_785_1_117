// package com.example.demo.service;

// import com.example.demo.entity.PolicyRule;
// import java.util.*;

// public interface PolicyRuleService {
//     PolicyRule createRule(PolicyRule rule);
//     PolicyRule updateRule(Long id, PolicyRule rule);
//     List<PolicyRule> getActiveRules();
//     PolicyRule getRuleByCode(String ruleCode);
//     List<PolicyRule> getAllRules();
// }
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;
public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule r);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
}
