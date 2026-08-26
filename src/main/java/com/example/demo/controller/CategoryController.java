package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Dto.ProductDto;
import com.example.demo.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("category")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping()
	public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDto dto) {
		categoryService.addCategory(dto);
		return new ResponseEntity<String>("Category saved", HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<CategoryDto>> getAllCategories() {

		return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {

		return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto dto) {

		return new ResponseEntity<>(categoryService.updateCategory(id, dto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

		categoryService.deleteCategory(id);
		return new ResponseEntity<>("Category Deleted", HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<List<ProductDto>> getProductByCategoryId(@PathVariable Long id) {

		return new ResponseEntity<>(categoryService.getProductsByCategory(id), HttpStatus.OK);
	}

}
