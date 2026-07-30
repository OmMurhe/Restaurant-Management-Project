package com.example.demo.Dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {

	@NotBlank(message = "Please enter customer name")
	private String name;

	@NotBlank(message = "Please enter a valid mobile number")
	private String mobile;

	@Email(message = "Please enter a valid email")
	@NotBlank(message = "Email is required")
	private String email;

	private LocalDateTime createdAt;
}