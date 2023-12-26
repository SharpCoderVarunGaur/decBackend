package com.employee.service;

import java.util.List;

import com.employee.entity.Role;



public interface RoleService {

	Role createRole(Role role);

	List<Role> getAllRole();

}
