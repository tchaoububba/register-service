package com.revature.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entity.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFact;
	
	@Override
	public void addUser(User user) {
		
		sessionFact.getCurrentSession().save(user);
		System.out.println(user + " saved");
		
	}

}
