package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    @Override
    public ViolationRecord logViolation(ViolationRecord v) {
        return violationRepo.save(v);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = violationRepo.findById(id).orElse(null);
        if(record == null) return null;

        record.setResolved(true);
        return violationRepo.save(record);
    }
}
