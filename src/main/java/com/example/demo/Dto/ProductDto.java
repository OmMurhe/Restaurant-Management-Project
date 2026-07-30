package com.example.demo.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
	
	 @NotBlank(message = "Plese enter The Product Name")
	   private String name;
	 
	 @NotBlank(message = "Plese Enter The product discription")
	   private String description;
	 
	 @NotNull(message = "Plese Enter The Price")
	   private Integer price; 
	 
	 @NotBlank(message = "Plese Provide The URL OF Image")
	   private String url;
	 
	 @NotNull(message = "Plese Apply The Status")
	   private Boolean available;
	 
	 @NotNull(message = "Plese Provide The PreparationTime")
	   private Integer preparationTime;
	
}
