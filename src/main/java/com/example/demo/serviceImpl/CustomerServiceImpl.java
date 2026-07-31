package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.CustomerDto;

import com.example.demo.entity.Customer;

import com.example.demo.exception.CustomerServiceException;
import com.example.demo.exception.ProductServiceException;
import com.example.demo.mapper.CustomerMapper;

import com.example.demo.repositary.CustomerRepo;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepo customerRepo;

	public CustomerServiceImpl(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;

	}

	@Override
	public CustomerDto addCustomer(CustomerDto dto) {
		if (customerRepo.existsByEmail(dto.getEmail())) {
			throw new CustomerServiceException("Email already exists", HttpStatus.CONFLICT);
		}

		if (customerRepo.existsByMobile(dto.getMobile())) {
			throw new CustomerServiceException("Mobile already exists", HttpStatus.CONFLICT);
		}

		Customer customer = CustomerMapper.mapToCustomer(dto);

		customer.setCreatedAt(LocalDateTime.now());

		Customer savedCustomer = customerRepo.save(customer);

		return CustomerMapper.mapToCustomerDto(savedCustomer);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerServiceException("Customer not fount", HttpStatus.NOT_FOUND);
		}
		List<CustomerDto> customerDto = customers.stream().map(p -> CustomerMapper.mapToCustomerDto(p))
				.collect(Collectors.toList());
		return customerDto;

	}

	@Override
	public CustomerDto getCustomer(int id) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerServiceException("Customer not found", HttpStatus.NOT_FOUND));
		CustomerDto dto = CustomerMapper.mapToCustomerDto(customer);
		return dto;
	}

	@Override
	public CustomerDto updateCustomer(int id, CustomerDto dto) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerServiceException("Customer not found", HttpStatus.NOT_FOUND));
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());
		customer.setMobile(dto.getMobile());

		Customer update = customerRepo.save(customer);
		return CustomerMapper.mapToCustomerDto(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepo.findById(id).orElseThrow(() -> new CustomerServiceException("Customer not found", HttpStatus.NOT_FOUND));
		customerRepo.deleteById(id);

	}

}
