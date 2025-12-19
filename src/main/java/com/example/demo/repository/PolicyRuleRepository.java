package com.example.demo.repository

public interface PolicyRuleRepository extends JpaRepository<PolicyRule,Long>{

    List<PolicyRule>
}