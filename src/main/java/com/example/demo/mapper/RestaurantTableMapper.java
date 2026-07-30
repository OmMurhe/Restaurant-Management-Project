package com.example.demo.mapper;

import com.example.demo.Dto.RestaurantTableDto;
import com.example.demo.entity.RestaurantTable;

public class RestaurantTableMapper {

    public static RestaurantTable mapToRestaurantTable(RestaurantTableDto dto) {

        RestaurantTable table = new RestaurantTable();

        table.setId(dto.getId());
        table.setTableNo(dto.getTableNo());
        table.setQrCodes(dto.getQrCodes());
        table.setTabletStatus(dto.getTabletStatus());

        return table;
    }

    public static RestaurantTableDto mapToRestaurantTableDto(RestaurantTable table) {

        RestaurantTableDto dto = new RestaurantTableDto();

        dto.setId(table.getId());
        dto.setTableNo(table.getTableNo());
        dto.setQrCodes(table.getQrCodes());
        dto.setTabletStatus(table.getTabletStatus());

        return dto;
    }
}	