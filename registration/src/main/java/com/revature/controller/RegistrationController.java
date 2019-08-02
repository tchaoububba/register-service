package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.User;
import com.revature.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RegistrationController")
public class RegistrationController {
	
	  @Autowired
	  public UserService userServiceImpl;
	  
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public void addUser(@RequestBody User user) {
		  System.out.println(user);
		  userServiceImpl.createUser(user);
	  }

}
