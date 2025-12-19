package com.example.demo.repository

public interface ViolationRecordRepository extends JpaReository<ViolationRrcord,Long>{
    List<ViolationRecord>findByUserId(Long,userId);
    List<ViolationRecord>findByResolvedFalse()
}