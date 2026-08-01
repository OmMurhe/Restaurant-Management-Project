package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.RestaurantTableDto;
import com.example.demo.service.RestaurantTableService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tables")
public class RestaurantTableController {

    private final RestaurantTableService service;

    public RestaurantTableController(RestaurantTableService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RestaurantTableDto> saveTable(@Valid @RequestBody RestaurantTableDto dto) {

        RestaurantTableDto savedTable = service.saveTable(dto);

        return new ResponseEntity<>(savedTable, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantTableDto>> getAllTables() {

        return ResponseEntity.ok(service.getAllTables());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTableDto> getTableById(@PathVariable Integer id) {

        return ResponseEntity.ok(service.getTableById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTableDto> updateTable(@PathVariable Integer id,
                                                          @Valid @RequestBody RestaurantTableDto dto) {

        return ResponseEntity.ok(service.updateTable(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTable(@PathVariable Integer id) {

        service.deleteTable(id);

        return ResponseEntity.ok("Restaurant Table Deleted Successfully");
    }
}