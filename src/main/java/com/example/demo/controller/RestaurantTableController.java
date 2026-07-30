package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Dto.RestaurantTableDto;
import com.example.demo.entity.RestaurantTable;
import com.example.demo.mapper.RestaurantTableMapper;
import com.example.demo.service.RestaurantTableService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tables")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService service;

    
    @PostMapping
    public RestaurantTableDto saveTable( @Valid @RequestBody RestaurantTableDto dto) {

        RestaurantTable table = RestaurantTableMapper.mapToRestaurantTable(dto);

        RestaurantTable savedTable = service.saveTable(table);

        return RestaurantTableMapper.mapToRestaurantTableDto(savedTable);
    }

    
    @GetMapping
    public List<RestaurantTableDto> getAllTables() {

        return service.getAllTables()
                .stream()
                .map(RestaurantTableMapper::mapToRestaurantTableDto)
                .collect(Collectors.toList());
    }

   
    @GetMapping("/{id}")
    public RestaurantTableDto getTableById(@PathVariable Integer id) {

        RestaurantTable table = service.getTableById(id);

        return RestaurantTableMapper.mapToRestaurantTableDto(table);
    }

    
    @PutMapping("/{id}")
    public RestaurantTableDto updateTable(@PathVariable Integer id,
                                          @RequestBody RestaurantTableDto dto) {

        RestaurantTable table = RestaurantTableMapper.mapToRestaurantTable(dto);

        RestaurantTable updatedTable = service.updateTable(id, table);

        return RestaurantTableMapper.mapToRestaurantTableDto(updatedTable);
    }

   
    @DeleteMapping("/{id}")
    public String deleteTable(@PathVariable Integer id) {

        service.deleteTable(id);

        return "Restaurant Table Deleted Successfully";
    }
}