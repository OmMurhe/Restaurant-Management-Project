package com.example.demo.mapper;

import com.example.demo.Dto.OrderItemDto;
import com.example.demo.Dto.OrderItemResponseDto;
import com.example.demo.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem mapToOrderItem(OrderItemDto dto) {

        OrderItem orderItem = new OrderItem();

        orderItem.setQuantity(dto.getQuantity());

        return orderItem;
    }

    public static OrderItemResponseDto mapToOrderItemResponseDto(OrderItem orderItem) {

        OrderItemResponseDto dto = new OrderItemResponseDto();

        dto.setProductId(orderItem.getProduct().getId());
        dto.setProductName(orderItem.getProduct().getName());
        dto.setPrice(orderItem.getPrice());
        dto.setQuantity(orderItem.getQuantity());
        dto.setSubTotal(orderItem.getSubTotal());

        return dto;
    }
}