package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	boolean existsByName(String name);

}
