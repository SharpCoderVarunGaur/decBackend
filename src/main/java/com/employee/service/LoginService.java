package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.entity.Login;

@Component
public interface LoginService {
	
	public Login createLogin(Login login);
	
	public List<Login> getLogin();

}
