package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Login;
import com.employee.entity.Role;
import com.employee.repo.RoleRepo;
import com.employee.service.LoginService;
import com.employee.serviceimpl.LoginServiceImpl;


@RestController
@RequestMapping("Sign-up")
public class LoginController {

	@Autowired
	private LoginServiceImpl impl;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private RoleRepo repo;
	
	@PostMapping
	public ResponseEntity<Login> createLogin(@RequestBody Login login){
		System.out.println("Hello");
		String password=this.encoder.encode(login.getPassword());
		Optional<Role> r = this.repo.findById(login.getRole().getId());
		Role r1 = r.get();
		login.setRole(r1);
		login.setPassword(password);
		Login l=this.impl.createLogin(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(l);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Login>> getAllLogin(){
		List<Login> l=this.impl.getLogin();
	     System.out.println(l.get(1).getRole().getRoleName());
	return ResponseEntity.ok(l);
	}
	
	
}
