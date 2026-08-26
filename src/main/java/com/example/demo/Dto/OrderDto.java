package com.example.demo.Dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {

    @NotNull(message = "Please provide customer id")
    private Integer customerId;

    @NotNull(message = "Please provide table id")
    private Integer tableId;

    @NotEmpty(message = "Order must contain at least one product")
    @Valid
    private List<OrderItemDto> orderItems;

    private String specialInstructions;
}