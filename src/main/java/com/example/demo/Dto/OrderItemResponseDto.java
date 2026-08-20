package com.example.demo.Dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemResponseDto {

    private Integer productId;

    private String productName;

    private Integer price;

    private Integer quantity;

    private Integer subTotal;
}