package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Dto.OrderResponseDto;

public interface OrderService {

	OrderResponseDto addOrder(OrderDto dto);

	List<OrderResponseDto> getAllOrders();

	OrderResponseDto getOrder(int id);

	OrderResponseDto updateOrder(int id, OrderDto dto);

	void deleteOrder(int id);

}