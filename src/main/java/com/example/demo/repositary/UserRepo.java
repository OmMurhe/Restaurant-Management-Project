package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	boolean existsByEmail(String email);
	boolean existsByMobileNumber(String mobileNumber);
	
	boolean existsByEmailAndIdNot(String email, int id);

	boolean existsByMobileNumberAndIdNot(String mobileNumber, int id);

}
