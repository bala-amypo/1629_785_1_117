package com.example.demo.repository;

import com.example.demo.entity.ViolationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationRecordRepository extends JpaReository<ViolationRrcord,Long>{
    List<ViolationRecord>findByUserId(Long,userId);
    List<ViolationRecord>findByResolvedFalse();
}