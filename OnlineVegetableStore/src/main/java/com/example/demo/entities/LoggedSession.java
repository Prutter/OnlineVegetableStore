package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class LoggedSession {
	@Id
	@Column(unique = true)
	private Integer userId;
	private String uniquekey;
	private String role;
	private LocalDateTime localDateTime;
	public LoggedSession() {
		super();
	}
	public LoggedSession(Integer userId, String uniquekey, String role, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.uniquekey = uniquekey;
		this.role = role;
		this.localDateTime = localDateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUniquekey() {
		return uniquekey;
	}
	public void setUniquekey(String uniquekey) {
		this.uniquekey = uniquekey;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	@Override
	public String toString() {
		return "LoggedSession [userId=" + userId + ", uniquekey=" + uniquekey + ", role=" + role + ", localDateTime="
				+ localDateTime + "]";
	}
}
