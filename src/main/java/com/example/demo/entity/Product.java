package com.example.demo.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
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
	@Column(nullable = false, unique = true)
   private String name;
   private String description;
   @Column(name ="product_price", nullable = false)
   private Integer price; 
   @Column(name ="product_url", nullable = false)
   private String url;
   @Column(name ="avalibility", nullable = false)
   private Boolean available;
   @Column(name ="preparation_time", nullable = false)
   private Integer preparationTime;
   private LocalDate createdAt;
     
   //@ManyToOne
  // @JoinColumn(name="category_id")
   //private Category category;
}
