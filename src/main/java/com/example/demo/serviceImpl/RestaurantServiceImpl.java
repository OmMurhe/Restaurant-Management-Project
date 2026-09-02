package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.RestaurantDto;
import com.example.demo.entity.Restaurant;
import com.example.demo.exception.RestaurantServiceException;
import com.example.demo.mapper.RestaurantMapper;
import com.example.demo.repositary.RestaurantRepo;
import com.example.demo.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepo restaurantRepo;

	public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
		this.restaurantRepo = restaurantRepo;
	}

	@Override
	public RestaurantDto addRestaurant(RestaurantDto dto) {

		if (restaurantRepo.existsByPhone(dto.getPhone())) {
			throw new RestaurantServiceException("Restaurant phone number already exists", HttpStatus.CONFLICT);
		}

		if (restaurantRepo.existsByEmail(dto.getEmail())) {
			throw new RestaurantServiceException("Restaurant email already exists", HttpStatus.CONFLICT);
		}

		Restaurant restaurant = RestaurantMapper.mapToEntity(dto);

		Restaurant savedRestaurant = restaurantRepo.save(restaurant);

		return RestaurantMapper.mapToDto(savedRestaurant);
	}

	@Override
	public List<RestaurantDto> getAllRestaurants() {
		return restaurantRepo.findAll().stream().map(RestaurantMapper::mapToDto).collect(Collectors.toList());
	}

	@Override
	public RestaurantDto getRestaurantById(Long id) {
		Restaurant restaurant = restaurantRepo.findById(id)
				.orElseThrow(() -> new RestaurantServiceException("Restaurant not found", HttpStatus.NOT_FOUND));

		return RestaurantMapper.mapToDto(restaurant);
	}

	@Override
	public RestaurantDto updateRestaurant(Long id, RestaurantDto dto) {
		Restaurant restaurant = restaurantRepo.findById(id)
				.orElseThrow(() -> new RestaurantServiceException("Restaurant not found", HttpStatus.NOT_FOUND));

		if (restaurantRepo.existsByPhoneAndIdNot(dto.getPhone(), id)) {
			throw new RestaurantServiceException("Phone number already exists", HttpStatus.CONFLICT);
		}

		if (restaurantRepo.existsByEmailAndIdNot(dto.getEmail(), id)) {
			throw new RestaurantServiceException("Email already exists", HttpStatus.CONFLICT);
		}
		restaurant.setName(dto.getName());
		restaurant.setAddress(dto.getAddress());
		restaurant.setPhone(dto.getPhone());
		restaurant.setEmail(dto.getEmail());
		restaurant.setOpeningTime(dto.getOpeningTime());
		restaurant.setClosingTime(dto.getClosingTime());

		Restaurant updatedRestaurant = restaurantRepo.save(restaurant);
		return RestaurantMapper.mapToDto(updatedRestaurant);
	}

	@Override
	public void deleteRestaurant(Long id) {
		if (restaurantRepo.existsById(id)) {
			throw new RestaurantServiceException("Email already exists", HttpStatus.CONFLICT);
		}
		restaurantRepo.deleteById(id);
	}
}