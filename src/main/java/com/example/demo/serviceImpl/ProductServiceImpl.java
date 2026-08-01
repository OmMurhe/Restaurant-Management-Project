package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductServiceException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repositary.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepo productRepo;
	
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo=productRepo;
	}

	@Override
	public void addProduct(ProductDto dto) {
	if(productRepo.existsByName(dto.getName())) {
		throw new ProductServiceException("Product is already exists",HttpStatus.CONFLICT);
	}
	
	Product product=ProductMapper.mapToProduct(dto);
	product.setCreatedAt(LocalDate.now());
	productRepo.save(product);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products=productRepo.findAll();
		if(products.isEmpty()) {
			throw new ProductServiceException("Product not fount",HttpStatus.NOT_FOUND);
		}
		
		List<ProductDto> productDto=products.stream().map(p -> ProductMapper.mapToProductDto(p)).collect(Collectors.toList());
		return productDto;
	}

	@Override
	public ProductDto getProduct(int id) {
		Product product=productRepo.findById(id).orElseThrow( () ->  new ProductServiceException("Product not found",HttpStatus.NOT_FOUND));
		ProductDto dto=ProductMapper.mapToProductDto(product);
		return dto;
	}

	@Override
	public ProductDto updateProduct(int id, ProductDto dto) {
		Product product=productRepo.findById(id).orElseThrow( () ->  new ProductServiceException("Product not found",HttpStatus.NOT_FOUND));
	product.setName(dto.getName());
	product.setDescription(dto.getDescription());
	product.setPrice(dto.getPrice());
	product.setAvailable(dto.getAvailable());
	product.setPreparationTime(dto.getPreparationTime());
	product.setUrl(dto.getUrl());
	
	Product update=productRepo.save(product);
	return ProductMapper.mapToProductDto(update);
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.findById(id).orElseThrow( () ->  new ProductServiceException("Product not found",HttpStatus.NOT_FOUND));
		productRepo.deleteById(id);
		
	}

}
