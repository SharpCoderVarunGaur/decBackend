package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.security.JwtHelper;
import com.employee.security.Response;
import com.employee.security.WtRequest;

@RestController
@RequestMapping("token")
public class TokenGenerator {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtHelper helper;
	
	
	@PostMapping
	public ResponseEntity<Response> createToekn(@RequestBody WtRequest  request ){
		
		try{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));
			  
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("Invalid user name");
		}
		
		UserDetails userDetails=this.detailsService.loadUserByUsername(request.getUserName());
		String token =this.helper.generateToken(userDetails);
		Response res=new Response();
		res.setToken(token);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		   
		
	}


	
}
