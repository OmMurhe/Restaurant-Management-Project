package com.example.demo.Dto;

import java.time.LocalDate;


import com.example.demo.Enums.Roles;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	@NotBlank(message = "Plese enter the name")
	private String name;
	
	@NotBlank(message = "Plese enter the Email")
	@Email(message = "Plese Entet valic email")
	private String email;
	
	@NotBlank(message = "Plese enter the password")
	private String password;
	
	@NotBlank(message = "Plese enter mobile number")
	private String mobileNumber;
	
     @NotNull(message = "Please select role")
	 private Roles role;
	
	 private LocalDate createdAt;
	
	 private boolean active;
}
