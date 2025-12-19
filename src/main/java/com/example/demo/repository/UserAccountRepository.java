package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.Jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,long>{
Optional<UserAccount>findByUsername(String username);

Optional<UserAccount>

}