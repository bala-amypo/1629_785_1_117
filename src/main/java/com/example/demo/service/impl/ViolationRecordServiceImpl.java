package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

import java.util.*;

public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return violationRepo.findByUserId(userId);
    }

    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = violationRepo.findById(id).orElseThrow();
        v.setResolved(true);
        return violationRepo.save(v);
    }

    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    public List<ViolationRecord> getAllViolations() {
        return violationRepo.findAll();
    }
}
