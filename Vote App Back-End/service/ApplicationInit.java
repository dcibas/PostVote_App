package com.codeacademy.voteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.codeacademy.voteapp.entity.Role;
import com.codeacademy.voteapp.enu.Roles;
import com.codeacademy.voteapp.repository.RoleRepo;


@Component
public class ApplicationInit implements ApplicationRunner {

	@Autowired
	RoleRepo repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		if(repository.findByRole(Roles.ROLE_USER).isEmpty()) {
			Role user = new Role();
			user.setRole(Roles.ROLE_USER);
			repository.save(user);
		}
		
		if(repository.findByRole(Roles.ROLE_ADMIN).isEmpty()) {
			Role admin = new Role();
			admin.setRole(Roles.ROLE_ADMIN);
			repository.save(admin);
		}
		
	}

}
