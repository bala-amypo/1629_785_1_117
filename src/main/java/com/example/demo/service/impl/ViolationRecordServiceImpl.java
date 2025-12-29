package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    @Override
    public ViolationRecord logViolation(ViolationRecord record) {
        record.setTimestamp(LocalDateTime.now());
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord vr = repo.findById(id).orElseThrow();
        vr.setResolved(true);
        return repo.save(vr);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }
}
