package com.example.demo.mapper;

import com.example.demo.Dto.RestaurantDto;
import com.example.demo.entity.Restaurant;

public class RestaurantMapper {

    private RestaurantMapper() {
    }

    public static Restaurant mapToEntity(RestaurantDto dto) {
        Restaurant restaurant = new Restaurant();

        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhone(dto.getPhone());
        restaurant.setEmail(dto.getEmail());
        restaurant.setOpeningTime(dto.getOpeningTime());
        restaurant.setClosingTime(dto.getClosingTime());

        return restaurant;
    }

    public static RestaurantDto mapToDto(Restaurant restaurant) {
        RestaurantDto dto = new RestaurantDto();

        dto.setName(restaurant.getName());
        dto.setAddress(restaurant.getAddress());
        dto.setPhone(restaurant.getPhone());
        dto.setEmail(restaurant.getEmail());
        dto.setOpeningTime(restaurant.getOpeningTime());
        dto.setClosingTime(restaurant.getClosingTime());
        dto.setActive(restaurant.getActive());
        dto.setCreatedAt(restaurant.getCreatedAt());

        return dto;
    }
}