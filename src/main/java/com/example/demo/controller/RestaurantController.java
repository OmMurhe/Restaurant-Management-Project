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

import com.example.demo.Dto.RestaurantDto;
import com.example.demo.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

	private final RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@PostMapping
	public ResponseEntity<RestaurantDto> addRestaurant(@Valid @RequestBody RestaurantDto dto) {

		return new ResponseEntity<>(restaurantService.addRestaurant(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
		return ResponseEntity.ok(restaurantService.getAllRestaurants());
	}

	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id) {

		return ResponseEntity.ok(restaurantService.getRestaurantById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable Long id,
			@Valid @RequestBody RestaurantDto dto) {

		return ResponseEntity.ok(restaurantService.updateRestaurant(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
		restaurantService.deleteRestaurant(id);
		return ResponseEntity.ok("Restaurant deactivated successfully");
	}
}