package com.codeacademy.voteapp.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeacademy.voteapp.dto.LoginDto;
import com.codeacademy.voteapp.dto.SignupDto;
import com.codeacademy.voteapp.dto.UserDto;
import com.codeacademy.voteapp.security.jwt.JwtUtils;
import com.codeacademy.voteapp.security.services.UserDetailsImpl;
import com.codeacademy.voteapp.service.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signups")
	public UserDto signup(@Valid @RequestBody SignupDto signupDto) throws Exception{
		return authService.signup(signupDto);
	}
	
	@PostMapping("/logins")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager
		        .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
				
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		String jwtToken = jwtUtils.generateJwtToken(userDetails);
		UserDto newUserDto = new UserDto();
		newUserDto.setId(userDetails.getId());
		return ResponseEntity.ok()
		        .header(HttpHeaders.AUTHORIZATION, jwtToken)
		        .header("Access-Control-Expose-Headers", "Authorization")
		        .body(newUserDto);
	}
	
}

