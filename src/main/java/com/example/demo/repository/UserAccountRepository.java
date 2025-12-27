// package com.example.demo.repository;

// import com.example.demo.entity.UserAccount;
// import java.util.*;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
//     Optional<UserAccount> findByUsername(String username);
//     Optional<UserAccount> findByEmail(String email);
// }

package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;

public interface UserAccountRepository {
    UserAccount save(UserAccount u);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
}
