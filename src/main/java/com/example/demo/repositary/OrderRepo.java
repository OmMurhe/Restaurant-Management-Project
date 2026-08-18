package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.entity.Order;

public interface OrderRepo extends JpaRepository<Order , Integer> {

	boolean existsByOrderNumber(String orderNumber);
}
