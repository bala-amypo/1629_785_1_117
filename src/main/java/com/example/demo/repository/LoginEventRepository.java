// package com.example.demo.repository;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.entity.UserAccount;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

//     List<LoginEvent> findByUser(UserAccount user);                         // instead of findByUserId
//     List<LoginEvent> findByUserAndLoginStatus(UserAccount user, String status);
// }






package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface LoginEventRepository {
    LoginEvent save(LoginEvent e);
    List<LoginEvent> findByUserId(Long id);
    List<LoginEvent> findByUserIdAndLoginStatus(Long id, String status);
}
