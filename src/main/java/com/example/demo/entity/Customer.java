package com.example.demo.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "customer_name", nullable = false)
	private String name;

	@Column(name = "customer_no", unique = true, nullable = false)
	private String mobile;

	@Column(name = "customer_email", unique = true, nullable = false)
	private String email;

	private LocalDateTime createdAt;

	

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}

	
}