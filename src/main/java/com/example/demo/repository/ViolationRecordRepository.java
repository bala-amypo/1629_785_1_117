// package com.example.demo.repository;

// import com.example.demo.entity.ViolationRecord;
// import java.util.*;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface ViolationRecordRepository extends JpaRepository<ViolationRecord, Long> {
//     List<ViolationRecord> findByUserId(Long userId);
//     List<ViolationRecord> findByResolvedFalse();
// }

package com.example.demo.repository;
import com.example.demo.entity.ViolationRecord;
// import com.example.demo.entity.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRecordRepository extends JpaRepository<ViolationRecord, Long>{
    ViolationRecord save(ViolationRecord v);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
}
