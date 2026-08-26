package com.example.demo.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Dto.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.exception.CategoryServiceException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repositary.CategoryRepo;
import com.example.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepo categoryRepo;

	public CategoryServiceImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public CategoryDto addCategory(CategoryDto dto) {
		if (categoryRepo.existsByName(dto.getName())) {
			throw new CategoryServiceException("Category already exists", HttpStatus.CONFLICT);
		}
		Category category = CategoryMapper.mapToCategory(dto);

		Category saved = categoryRepo.save(category);
		return CategoryMapper.mapToCategoryDto(saved);

	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> category = categoryRepo.findAll();
		if (category.isEmpty()) {
			throw new CategoryServiceException("Category not found", HttpStatus.NOT_FOUND);
		}
		List<CategoryDto> categoryDto = category.stream().map(p -> CategoryMapper.mapToCategoryDto(p))
				.collect(Collectors.toList());
		return categoryDto;
	}

	@Override
	public CategoryDto getCategory(Long id) {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new CategoryServiceException("Category not found", HttpStatus.NOT_FOUND));
		CategoryDto categoryDto = CategoryMapper.mapToCategoryDto(category);
		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(Long id, CategoryDto dto) {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new CategoryServiceException("Category not found", HttpStatus.NOT_FOUND));
		category.setName(dto.getName());
		category.setDescription(dto.getDescription());
		category.setDisplayOrder(dto.getDisplayOrder());
		category.setStatus(dto.getStatus());
		category.setImageUrl(dto.getImageUrl());
		Category updated = categoryRepo.save(category);

		return CategoryMapper.mapToCategoryDto(updated);

	}

	@Override
	public void deleteCategory(Long id) {
		if(!categoryRepo.existsById(id)) {
			throw new CategoryServiceException("Category not found", HttpStatus.NOT_FOUND);
		}

		categoryRepo.deleteById(id);
	}

	@Override
	public List<ProductDto> getProductsByCategory(Long categoryId) {
	    Category category = categoryRepo.findById(categoryId)
	        .orElseThrow(() -> new CategoryServiceException("Category not found", HttpStatus.NOT_FOUND));

	    return category.getProducts().stream()
	            .map(ProductMapper::mapToProductDto)
	            .collect(Collectors.toList());
	}

}
