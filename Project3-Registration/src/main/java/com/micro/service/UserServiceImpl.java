package com.micro.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.micro.dao.UserRepository;
import com.micro.dto.UserDTO;
import com.micro.entity.User;

@Service("userService")
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
		BCryptPasswordEncoder bc =new BCryptPasswordEncoder();
		User userEntity = modelMapper.map(userDetail, User.class);
		userEntity.setPassword(bc.encode(userDetail.getPassword()));
		if(userEntity.getRole()!=null) {
		if(userEntity.getRole().equals("true")) {
			userEntity.setRole("QC");
		}
		if(userEntity.getRole().equals("false")) {
			userEntity.setRole("USER");
		}
		}
		else {
			userEntity.setRole("USER");
		}
		System.out.println("Set User entity "+ userEntity);
		ur.save(userEntity);
		System.out.println(userEntity.getId());
		UserDTO returnValue = modelMapper.map(userDetail, UserDTO.class);
		return returnValue;
	}

}
