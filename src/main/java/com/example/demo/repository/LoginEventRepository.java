package com.example.demo.repository

import com.example.demo.entity.LoginEvent;
import org.sprinframework.data.Jpa.repository.JpaRepository;


public interface LoginEventRepository extends JpaRepository<LoginEvent,Long>{

}