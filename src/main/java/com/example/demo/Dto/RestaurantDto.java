package com.example.demo.Dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Phone is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be 10 digits")
	private String phone;
	@NotBlank(message = "Email is required")
	@Email(message = "Please enter a valid Email address")
	private String email;
	@NotNull(message = "Opening time is required")
	private LocalTime openingTime;
	@NotNull(message = "Closing time is required")
	private LocalTime closingTime;
	
	private Boolean active;
	
    private LocalDateTime createdAt;
    
    
}
