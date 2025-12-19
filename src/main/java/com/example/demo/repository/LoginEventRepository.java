package com.example.demo.repository

import com.example.demo.entity.LoginEvent;
import org.sprinframework.data.Jpa.repository.JpaRepository;
import java.util.List;


public interface LoginEventRepository extends JpaRepository<LoginEvent,Long>{

   List<LoginEvent>findByUserId(Londg userId);
   List<LoginEvent>findByUserIdAndLoginStatus(Long userId,String loginStatus);
   
}