package com.codeacademy.voteapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.SignupDto;
import com.codeacademy.voteapp.dto.UserDto;
import com.codeacademy.voteapp.entity.Role;
import com.codeacademy.voteapp.entity.User;
import com.codeacademy.voteapp.enu.Roles;
import com.codeacademy.voteapp.mapper.UserMapper;
import com.codeacademy.voteapp.repository.RoleRepo;
import com.codeacademy.voteapp.repository.UserRepo;


@Service
public class AuthService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo rolesRepo;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserDto signup(SignupDto signupDto) throws Exception {
		
	if(userRepo.findByEmail(signupDto.getEmail()).isPresent()) {
		throw new Exception("Email " + signupDto.getEmail() + " is already in use");
	}
		
	if(!signupDto.getPassword().equals(signupDto.getRepeatPassword())) {
		throw new Exception("Password do not match");
	}
	
	User newUser = new User();
	newUser.setName(signupDto.getName());
	newUser.setSurname(signupDto.getSurname());
	newUser.setEmail(signupDto.getEmail());
	newUser.setPassword(passwordEncoder.encode(signupDto.getPassword()));
	newUser.setAge(signupDto.getAge());
	newUser.setAddress(signupDto.getAddress());
	newUser.setSignupDate(LocalDateTime.now());
	
	Role userRole = rolesRepo.findByRole(Roles.ROLE_USER).orElseThrow();
	
	List<Role> userRoles = new ArrayList<>();
	userRoles.add(userRole);
	newUser.setRoles(userRoles);
	
	userRepo.save(newUser);
	return userMapper.toDto(newUser);
	
	}
	
}
