package com.example.demo.mapper;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.entity.Customer;

public class CustomerMapper {

	public static Customer mapToCustomer(CustomerDto dto) {
		

		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setMobile(dto.getMobile());
		customer.setEmail(dto.getEmail());
		return customer;
	}

	public static CustomerDto mapToCustomerDto(Customer customer) {


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