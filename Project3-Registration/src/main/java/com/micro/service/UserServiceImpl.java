package com.micro.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.dao.UserRepository;
import com.micro.dto.UserDTO;
import com.micro.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository ur;
	@Autowired
	public UserServiceImpl( UserRepository UserRepository) {
		this.ur=UserRepository;
	}
	@Override
	@Transactional
	public UserDTO newUser(UserDTO userDetail) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		User userEntity = modelMapper.map(userDetail, User.class);
		System.out.println("Set User entity "+ userEntity);
		ur.save(userEntity);
		System.out.println(userEntity.getId());
		UserDTO returnValue = modelMapper.map(userDetail, UserDTO.class);
		return returnValue;
	}

}