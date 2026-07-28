package com.example.demo.mapper;

import com.example.demo.Dto.ProductDto;
import com.example.demo.entity.Product;

public class ProductMapper {
	
	public static Product mapToProduct(ProductDto dto) {
	Product product=new Product();
	product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setPreparationTime(dto.getPreparationTime());
    product.setAvailable(dto.getAvailable());
    product.setUrl(dto.getUrl());
    
    return product;
    
	}

	public static ProductDto mapToProductDto(Product product) {
		ProductDto dto=new ProductDto();
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setPreparationTime(product.getPreparationTime());
		dto.setPrice(product.getPrice());
		dto.setAvailable(product.getAvailable());
		dto.setUrl(product.getUrl());
		
		return dto;
		
	}
}
