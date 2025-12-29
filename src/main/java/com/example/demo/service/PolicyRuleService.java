package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule rule);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
}





// package com.example.demo.service;

// import com.example.demo.entity.*;
// import java.util.*;
// public interface PolicyRuleService {
//     PolicyRule createRule(PolicyRule r);
//     List<PolicyRule> getActiveRules();
//     List<PolicyRule> getAllRules();
// }
