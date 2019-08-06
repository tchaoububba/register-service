package com.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.dto.UserDTO;
import com.micro.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	UserService userservice;
	
	@Autowired
	public UserController (UserService theUserservice) {
		userservice = theUserservice;
	}
	
	@GetMapping("/hello")
	public String hello() {
		
		return "Hi there";
	}
	
	@PostMapping("/User")
	public ResponseEntity<UserDTO> addCustomer(@RequestBody UserDTO userdto)
	{
		UserDTO createdUser = userservice.newUser(userdto);
		System.out.println(createdUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(userdto);
	}
	
}
