package com.example.demo.Dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 50)
	private String name;

	@NotBlank(message = "Mobile is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be 10 digits")
	private String mobile;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email")
	private String email;

	private LocalDateTime createdAt;
}