package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAOImpl;
import com.revature.entity.User;

@Service ("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAOImpl usersDAOImpl;
	
	@Override
	@Transactional
	public void createUser(User user) {
		// adds a single user to a table
		usersDAOImpl.addUser(user);
	}
	
}
