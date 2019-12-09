package com.ncit.minor.futsalbookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncit.minor.futsalbookingapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
