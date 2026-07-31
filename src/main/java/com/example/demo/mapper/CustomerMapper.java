package com.example.demo.mapper;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.entity.Customer;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDto dto) {
		if (dto == null) return null;

		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setMobile(dto.getMobile());
		customer.setEmail(dto.getEmail());
		return customer;
	}

	public static CustomerDto mapToCustomerDto(Customer customer) {
		if (customer == null) return null;

		CustomerDto dto = new CustomerDto();
		dto.setName(customer.getName());
		dto.setMobile(customer.getMobile());
		dto.setEmail(customer.getEmail());
		dto.setCreatedAt(customer.getCreatedAt());
		return dto;
	}

	public static void updateCustomerFromDto(CustomerDto dto, Customer customer) {
		customer.setName(dto.getName());
		customer.setMobile(dto.getMobile());
		customer.setEmail(dto.getEmail());
	}
}