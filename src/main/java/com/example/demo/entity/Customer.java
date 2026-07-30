package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobile;
	private String email;
	private LocalDateTime createdAt;

	public Customer() {
	}

	public Customer(String name, String mobile, String email, LocalDateTime createdAt) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.createdAt = createdAt;
	}

	
}
