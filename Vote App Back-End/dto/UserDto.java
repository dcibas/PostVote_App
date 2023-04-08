package com.codeacademy.voteapp.dto;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.codeacademy.voteapp.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;
	
	@NotBlank(message = "Please enter a valid full name")
	private String name;
	
	@NotBlank(message = "Please enter a valid last name")
	private String surname;
	
	@NotNull(message = "Age cannot be null")
	private Integer age;
	
	@NotBlank(message = "Please enter a valid full address")
	private String address;
	
	@Email(message = "Please enter a valid email")
	private String email;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime signupDate;
	
	private List <Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
