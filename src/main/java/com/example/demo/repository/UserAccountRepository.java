package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.Jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,long>{

Optional<UserAccount>findByUsername(String username);  //unique username
Optional<UserAccount>findByEmail(String Email);        //unique email

}