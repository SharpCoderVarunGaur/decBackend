package com.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Role;
import com.employee.repo.RoleRepo;
import com.employee.service.RoleService;



@Service
public class RoleServieImpl implements RoleService {

	@Autowired
	private RoleRepo repo;

	@Override
	public Role createRole(Role role) {
		Role r = this.repo.save(role);

		return r;
	}

	@Override
	public List<Role> getAllRole() {
		List<Role> r = this.repo.findAll();

		return r;
	}

}
