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

import com.example.demo.Dto.CustomerDto;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping()
	public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerDto dto) {
		customerService.addCustomer(dto);
		return new ResponseEntity<String>("Customer saved", HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<CustomerDto>> getAllCustomer() {

		return new ResponseEntity<List<CustomerDto>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id){
		return new ResponseEntity <CustomerDto> (customerService.getCustomer(id),HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable int id,@Valid @RequestBody CustomerDto dto){
		return new ResponseEntity<CustomerDto>(customerService.updateCustomer(id, dto),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer deleted",HttpStatus.OK);
	}
	
}
