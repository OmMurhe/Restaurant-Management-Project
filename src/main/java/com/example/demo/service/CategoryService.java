package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Dto.ProductDto;

public interface CategoryService {

	public CategoryDto addCategory(CategoryDto dto);

	public List<CategoryDto> getAllCategories();

	public CategoryDto getCategory(Long id);

	public CategoryDto updateCategory(Long id, CategoryDto dto);

	public void deleteCategory(Long id);

	List<ProductDto> getProductsByCategory(Long categoryId);

}
