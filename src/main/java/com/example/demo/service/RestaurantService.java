package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.RestaurantDto;

public interface RestaurantService {

	
	public RestaurantDto addRestaurant(RestaurantDto dto);
	
	public List<RestaurantDto> getAllRestaurants();

	public RestaurantDto getRestaurantById(Long id);

	public RestaurantDto updateRestaurant(Long id, RestaurantDto dto);

	public void deleteRestaurant(Long id);

	

	
	
	
	
	
	
	
	
	
}