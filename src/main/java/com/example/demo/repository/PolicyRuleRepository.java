package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {
    List<PolicyRule> findByActiveTrue();   // REQUIRED BY TESTCASE #17 & #19 & #20
}





// package com.example.demo.repository;

// import com.example.demo.entity.*;
// import java.util.*;

// public interface PolicyRuleRepository {
//     PolicyRule save(PolicyRule r);
//     List<PolicyRule> findByActiveTrue();
//     List<PolicyRule> findAll();
// }
