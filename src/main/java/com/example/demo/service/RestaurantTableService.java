package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.RestaurantTableDto;

public interface RestaurantTableService {

    RestaurantTableDto saveTable(RestaurantTableDto dto);

    List<RestaurantTableDto> getAllTables();

    RestaurantTableDto getTableById(Integer id);

    RestaurantTableDto updateTable(Integer id, RestaurantTableDto dto);

    void deleteTable(Integer id);
}