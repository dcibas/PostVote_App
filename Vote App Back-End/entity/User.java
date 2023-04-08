package com.codeacademy.voteapp.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "surname")
	private String surname;
	
	@NotNull
	@Column(name = "age")
	private Integer age;
	
	@NotBlank
	@Column(name = "address")
	private String address;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name = "signup_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime signupDate;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List <VotePost> votePosts;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List <UserVotes> userVote;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<VotePost> getVotePosts() {
		return votePosts;
	}

	public void setVotePosts(List<VotePost> votePosts) {
		this.votePosts = votePosts;
	}

	public List<UserVotes> getUserVote() {
		return userVote;
	}

	public void setUserVote(List<UserVotes> userVote) {
		this.userVote = userVote;
	}

}
