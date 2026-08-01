package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RestaurantTable;

public interface TableRepository extends JpaRepository<RestaurantTable, Integer> {

}
