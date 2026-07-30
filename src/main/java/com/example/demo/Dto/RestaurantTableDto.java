package com.example.demo.Dto;

import com.example.demo.Enums.TableStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTableDto {
    private Integer id;
    @NotNull(message = "Please enter table number")
    private Integer tableNo;
    @NotBlank(message = "QR Code is required")
    private String qrCodes;
    @NotNull(message = "Table status is required")
    private TableStatus tabletStatus;
}