package com.example.demo.mapper;

import java.util.stream.Collectors;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Dto.OrderResponseDto;
import com.example.demo.entity.Order;

public class OrderMapper {

    public static Order mapToOrder(OrderDto dto) {

        Order order = new Order();

        order.setSpecialInstructions(dto.getSpecialInstructions());

        return order;
    }


    public static OrderResponseDto mapToOrderResponseDto(Order order) {

        OrderResponseDto dto = new OrderResponseDto();

        dto.setId(order.getId());
        dto.setOrderNumber(order.getOrderNumber());

        dto.setCustomerId(order.getCustomer().getId());
        dto.setTableId(order.getRestaurantTable().getId());

        dto.setTotalAmount(order.getTotalAmount());
        dto.setPaymentStatus(order.getPaymentStatus());
        dto.setOrderStatus(order.getOrderStatus());

        dto.setSpecialInstructions(order.getSpecialInstructions());
        dto.setOrderTime(order.getOrderTime());
        dto.setEstimatedReadyTime(order.getEstimatedReadyTime());

        if (order.getOrderItems() != null) {

            dto.setOrderItems(
                    order.getOrderItems()
                            .stream()
                            .map(OrderItemMapper::mapToOrderItemResponseDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}