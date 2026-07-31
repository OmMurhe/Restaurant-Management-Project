package com.example.demo.repositary;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	boolean existsByEmail(String email);

	boolean existsByMobile(String mobile);

	Optional<Customer> findByEmailAndIdNot(String email, int id);

	Optional<Customer> findByMobileAndIdNot(String mobile, int id);
}