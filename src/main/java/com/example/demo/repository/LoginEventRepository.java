// package com.example.demo.repository;

// import com.example.demo.entity.LoginEvent;
// import java.util.*;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {
//     List<LoginEvent> findByUserId(Long userId);
//     List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String status);
// }

package com.example.demo.repository;

// import com.example.demo.entity.*;
import java.util.*;
 import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {
    LoginEvent save(LoginEvent e);
    List<LoginEvent> findByUserId(Long id);
    List<LoginEvent> findByUserIdAndLoginStatus(Long id, String status);
}
