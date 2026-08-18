package com.example.demo.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.Enums.OrderStatus;
import com.example.demo.Enums.PaymentStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponseDto {

    private Integer id;

    private String orderNumber;

    private Integer customerId;

    private Integer tableId;

    private List<OrderItemResponseDto> orderItems;

    private Integer totalAmount;

    private PaymentStatus paymentStatus;

    private OrderStatus orderStatus;

    private String specialInstructions;

    private LocalDateTime orderTime;

    private LocalDateTime estimatedReadyTime;
}