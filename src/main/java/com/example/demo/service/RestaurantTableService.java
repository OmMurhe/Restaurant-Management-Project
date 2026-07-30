package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.RestaurantTable;

public interface RestaurantTableService {
	
	RestaurantTable saveTable(RestaurantTable table);

    List<RestaurantTable> getAllTables();

    RestaurantTable getTableById(Integer id);

    RestaurantTable updateTable(Integer id, RestaurantTable table);

    void deleteTable(Integer id);

}
