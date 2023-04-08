package com.codeacademy.voteapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.UserDto;
import com.codeacademy.voteapp.entity.User;
import com.codeacademy.voteapp.mapper.UserMapper;
import com.codeacademy.voteapp.repository.UserRepo;
import com.codeacademy.voteapp.repository.UserVotesRepo;
import com.codeacademy.voteapp.repository.VotePostRepo;


@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	VotePostRepo votePostRepo;

	@Autowired
	UserVotesRepo userVotesRepo;
	
	@Autowired
	UserMapper userMapper;
	
	
	
	public UserDto findById(Long id){
		
		User user = userRepo.findById(id).orElse(null);
		
		UserDto userDto = userMapper.toDto(user);
		
		return userDto;
		
	}
	
	public List<UserDto> findAllUsers(){
		
		List<User> users = (ArrayList<User>) userRepo.findAll();
		
		return userMapper.toDtoList(users);
		
	}
	
	public UserDto updateUser(UserDto userDto) {
		
		User user = userMapper.fromDto(userDto);
		
		User existingUser = userRepo.findById(userDto.getId()).orElse(null);
		
		user.setPassword(existingUser.getPassword());
		
		if(user.getSignupDate() == null) {
		
		user.setSignupDate(existingUser.getSignupDate());
		
		}
		
		userRepo.save(user);
		
		return userMapper.toDto(user);
		
	}
	
	public void deleteUser(Long id) {
		
		User existingUser = userRepo.findById(id).orElse(null);
		
		existingUser.getUserVote().forEach(vote -> vote.setUser(null));
		
		existingUser.getVotePosts().forEach(votePost -> votePost.setUser(null));
		
		votePostRepo.deleteAllById(existingUser.getVotePosts().stream().map(votepost -> votepost.getId()).collect(Collectors.toList()));
		
		userRepo.deleteById(id);
		
	}
	
}
