package com.employee.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.employee.entity.Login;





@Component
public class CustomUserDetail implements UserDetails {
	
	@Autowired
    private Login login;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	 SimpleGrantedAuthority	 simpleGranted=  new SimpleGrantedAuthority(getPassword());
		return List.of(simpleGranted);
	}

	@Override
	public String getPassword() {
		
		return login.getPassword();
	
	}

	@Override
	public String getUsername() {
		return login.getUserName();
	
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public CustomUserDetail() {
		super();
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public CustomUserDetail(Login login) {
		super();
		this.login = login;
	}

}
