package com.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.employee.entity.Login;

@Component
public interface LoginRepo extends JpaRepository<Login,Integer> {

}
