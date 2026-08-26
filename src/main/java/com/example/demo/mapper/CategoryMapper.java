package com.example.demo.mapper;

import com.example.demo.Dto.CategoryDto;

import com.example.demo.entity.Category;

public class CategoryMapper {

	public static Category mapToCategory(CategoryDto dto) {

		Category category = new Category();
		category.setName(dto.getName());
		category.setDescription(dto.getDescription());
		category.setDisplayOrder(dto.getDisplayOrder());
		category.setStatus(dto.getStatus());
		category.setImageUrl(dto.getImageUrl());
		return category;
	}

	public static CategoryDto mapToCategoryDto(Category category) {
		CategoryDto dto = new CategoryDto();
		dto.setName(category.getName());
		dto.setDescription(category.getDescription());
		dto.setDisplayOrder(category.getDisplayOrder());
		dto.setStatus(category.getStatus());
		dto.setImageUrl(category.getImageUrl());
		return dto;
	}

}
