
package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.Dto.ProductDto;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@PostMapping("product")
	public ResponseEntity<String> addProduct(@Valid  @RequestBody ProductDto dto){
		productService.addProduct(dto);
		return new ResponseEntity<String>("Product saved",HttpStatus.OK);
	}
	
	@GetMapping("products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		return new ResponseEntity<List<ProductDto>>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("product/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable int id){
		return new ResponseEntity<ProductDto>(productService.getProduct(id),HttpStatus.OK);
	}
	
	@PutMapping("product/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,@Valid @RequestBody ProductDto dto){
		return new ResponseEntity<ProductDto>(productService.updateProduct(id, dto),HttpStatus.OK);
	}
	
	@DeleteMapping("product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted",HttpStatus.OK);
	}
	
}
