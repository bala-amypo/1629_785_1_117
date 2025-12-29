// package com.example.demo.repository;

// import com.example.demo.entity.UserAccount;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
//     Optional<UserAccount> findByEmail(String email); // <-- Required for login & security
// }
























package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface UserAccountRepository {
    UserAccount save(UserAccount u);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
}
