package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Enums.CategoryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	private String description;

	@Column(nullable = false)
	private Integer displayOrder;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CategoryStatus status;

	@Column(updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "image_url")
	private String imageUrl;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> products;

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();

	}
}