package com.example.demo.Dto;

import com.example.demo.Enums.CategoryStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Description is required")
	private String description;

	@NotNull(message = "Display order is required")
	private Integer displayOrder;

	private String imageUrl;

	private CategoryStatus status;

}