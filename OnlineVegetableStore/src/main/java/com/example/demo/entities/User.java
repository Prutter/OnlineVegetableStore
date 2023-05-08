package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder.Default;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(unique = true)
	private String userName;
	
	@Email
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(unique = true)
	private String email;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$&])(?=\\S+$).{8,16}$", message = "Password must contains 8 to 16 characters and it should have at least one digit, one alphabet, one special character from the set [@#$&] and no whitespace allowed.")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Pattern(regexp="^[8-9]\\d{9}")
	@Column(unique = true)
	private String phone;
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String role;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		super();
	}
	
	public User(@Min(5) String userName, @Email @NotNull @NotEmpty @NotBlank String email,
			@NotNull @NotEmpty @NotBlank @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$&])(?=\\S+$).{8,16}$", message = "Password must contains 8 to 16 characters and it should have at least one digit, one alphabet, one special character from the set [@#$&] and no whitespace allowed.") String password,
			@Pattern(regexp = "^[8-9]\\d{9}") String phone, String role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	public User(Integer userId, @Min(5) String userName, @Email @NotNull @NotEmpty @NotBlank String email,
			@NotNull @NotEmpty @NotBlank @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$&])(?=\\S+$).{8,16}$", message = "Password must contains 8 to 16 characters and it should have at least one digit, one alphabet, one special character from the set [@#$&] and no whitespace allowed.") String password,
			@Pattern(regexp = "^[8-9]\\d{9}") String phone, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}
}
