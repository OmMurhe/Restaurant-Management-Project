package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "Order_items")
@Data
public class OrderItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name= "Order_No",nullable = false)
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name= "Product_id",nullable = false)
	private Product product ;
	
	@Column(name= "prod_Quantity",nullable = false)
	private Integer quantity;
	
	@Column(nullable = false, precision = 10,scale = 2)
	
	private Integer price;
	@Column (nullable =  false)
	private Integer subTotal;
}
