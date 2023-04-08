package com.codeacademy.voteapp.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.UserDto;
import com.codeacademy.voteapp.entity.User;

@Service
public class UserMapper {

	
	public UserDto toDto(User entity) {
		if(entity == null) {
			return null;
		}
	
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setAge(entity.getAge());
		dto.setAddress(entity.getAddress());
		dto.setEmail(entity.getEmail());
		dto.setSignupDate(entity.getSignupDate());
		dto.setRoles(entity.getRoles());
		
		return dto;
	
}

	public User fromDto(UserDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSurname(dto.getSurname());
		entity.setAge(dto.getAge());
		entity.setAddress(dto.getAddress());
		entity.setEmail(dto.getEmail());
		entity.setSignupDate(dto.getSignupDate());
		entity.setRoles(dto.getRoles());
		
		return entity;
		
	}
	
	public List<UserDto> toDtoList(List<User> entities) {
		
		List<UserDto> dtos = new ArrayList<>();
		
		for(User entity : entities) {
			dtos.add(toDto(entity));
		}
		
		return dtos;
					
	}		
	
}
