package com.micro.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.micro.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	

}
