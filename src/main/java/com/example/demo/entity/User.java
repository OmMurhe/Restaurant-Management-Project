package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.Enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User_Table")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="User_Name", nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String mobileNumber;
	@Column(nullable = false, unique = true)
	private String password;
	 @Enumerated(EnumType.STRING)
	 @Column(nullable = false)
	 private Roles role;

	private boolean active;
	private LocalDate createdAt;

}
