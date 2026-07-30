package com.example.demo.entity;

import com.example.demo.Enums.TableStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Entity()
@Table (name = "restaurant_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@Column(name = "Qr_codes",nullable = false)
	private  String qrCodes;
	@Column(name = "table_number",unique = true)
	private  Integer tableNo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TableStatus tabletStatus;

}
