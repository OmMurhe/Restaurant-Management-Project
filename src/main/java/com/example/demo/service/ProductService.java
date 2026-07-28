package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.ProductDto;

public interface ProductService {
	
	public void addProduct(ProductDto dto);
	public List<ProductDto> getAllProduct();
	public ProductDto getProduct(int id);
	public ProductDto updateProduct(int id,ProductDto dto);
	public void  deleteProduct(int id);

}
