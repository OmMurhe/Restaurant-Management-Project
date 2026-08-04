package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerServiceException;
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

		try {
			Customer saved = customerRepo.save(customer);
			return CustomerMapper.mapToCustomerDto(saved);
		} catch (DataIntegrityViolationException e) {
			throw new CustomerServiceException("Duplicate email or mobile", HttpStatus.CONFLICT);
		}
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		return customerRepo.findAll()
				.stream()
				.map(CustomerMapper::mapToCustomerDto)
				.toList();
	}

	@Override
	public CustomerDto getCustomer(int id) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerServiceException("Customer not found", HttpStatus.NOT_FOUND));

		return CustomerMapper.mapToCustomerDto(customer);
	}

	@Override
	public CustomerDto updateCustomer(int id, CustomerDto dto) {

		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerServiceException("Customer not found", HttpStatus.NOT_FOUND));

		if (customerRepo.findByEmailAndIdNot(dto.getEmail(), id).isPresent()) {
			throw new CustomerServiceException("Email already in use", HttpStatus.CONFLICT);
		}

		if (customerRepo.findByMobileAndIdNot(dto.getMobile(), id).isPresent()) {
			throw new CustomerServiceException("Mobile already in use", HttpStatus.CONFLICT);
		}

		CustomerMapper.updateCustomerFromDto(dto, customer);

		try {
			Customer updated = customerRepo.save(customer);
			return CustomerMapper.mapToCustomerDto(updated);
		} catch (DataIntegrityViolationException e) {
			throw new CustomerServiceException("Duplicate email or mobile", HttpStatus.CONFLICT);
		}
	}

	@Override
	public void deleteCustomer(int id) {

		if (!customerRepo.existsById(id)) {
			throw new CustomerServiceException("Customer not found", HttpStatus.NOT_FOUND);
		}

		customerRepo.deleteById(id);
	}
}