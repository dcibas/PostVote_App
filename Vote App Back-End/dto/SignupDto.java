package com.codeacademy.voteapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
	
	@NotBlank
	@Size(max = 30)
	private String name;
	
	@NotBlank
	@Size(max = 30)
	private String surname;
	
	@Email
	@NotBlank
	@Size(max = 50)
	private String email;
	
	@Size(min = 6, max = 20)
	@NotBlank
	private String password;
	
	@Size(min = 6, max = 20)
	@NotBlank
    private String repeatPassword;
	
	@Min(18)
	@Max(110)
	private Integer age;
	
	@Size(max = 50)
	@NotBlank
	private String address;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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
		
}
