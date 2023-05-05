package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.LoggedSession;

public interface LoggedSessionRepo extends JpaRepository<LoggedSession, Integer> {
	public LoggedSession findByuniquekey(String String);
}
