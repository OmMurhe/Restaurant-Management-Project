package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.CustomerDto;

public interface CustomerService {

    CustomerDto addCustomer(CustomerDto dto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomer(int id);

    CustomerDto updateCustomer(int id, CustomerDto dto);

    void deleteCustomer(int id);
}