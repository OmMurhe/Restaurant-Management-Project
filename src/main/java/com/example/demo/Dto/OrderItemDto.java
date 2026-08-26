package com.example.demo.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {

	@NotNull(message = "Please Provide Product Id")
	private Integer productId;

	@NotNull(message = "Please Provide Quantity")
	@Min(value = 1, message = "Quantity must be greater than zero")
	private Integer quantity;

}