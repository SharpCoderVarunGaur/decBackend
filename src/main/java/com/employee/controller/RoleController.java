package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Role;
import com.employee.serviceimpl.RoleServieImpl;



@RestController
@RequestMapping("Role")
public class RoleController {

	@Autowired
	private RoleServieImpl impl;

	@PostMapping
	public ResponseEntity<Role> createRole(@RequestBody Role role) {
		Role r = this.impl.createRole(role);
		System.out.println(r);
		return ResponseEntity.status(HttpStatus.CREATED).body(r);
	}

	@GetMapping
	public ResponseEntity<List<Role>> getAllrole() {
		List<Role> r = this.impl.getAllRole();
		return ResponseEntity.ok(r);
	}
}
