package com.codeacademy.voteapp.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codeacademy.voteapp.entity.Role;
import com.codeacademy.voteapp.enu.Roles;


@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

	Optional<Role> findByRole(Roles name);
	
}
