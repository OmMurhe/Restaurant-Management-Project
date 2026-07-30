package com.example.demo.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int	id;
   private String name;
   private String description;
   private Integer price; 
   private String url;
   private Boolean available;
   private Integer preparationTime;
   private LocalDate createdAt;
     
   //@ManyToOne
  // @JoinColumn(name="category_id")
   //private Category category;
}
