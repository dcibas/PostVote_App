package com.codeacademy.voteapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeacademy.voteapp.dto.UserDto;
import com.codeacademy.voteapp.service.UserService;


@CrossOrigin(origins = {"http://localhost:5500","http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/users")
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/{id}")
	public UserDto findById(@PathVariable(name="id") Long id) {
		
		return userService.findById(id);
		
	}
	
	@GetMapping("")
	public List<UserDto> findAllUsers() {
		
		return userService.findAllUsers();
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public UserDto updateUser(@Valid @RequestBody UserDto userDto, @PathVariable(name = "id") Long id) {
		
		userDto.setId(id);
		
		return userService.updateUser(userDto);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		
		userService.deleteUser(id);
		
	}
	
}
