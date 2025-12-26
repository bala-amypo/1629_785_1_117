package com.example.demo.repository;

import com.example.demo.entity.ViolationRecord;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationRecordRepository extends JpaRepository<ViolationRecord, Long> {
    List<ViolationRecord> findByUserId(Long userId);
    List<ViolationRecord> findByResolvedFalse();
}
