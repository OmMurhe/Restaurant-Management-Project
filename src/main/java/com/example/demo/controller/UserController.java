package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.Dto.UserDto;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userSerive) {
		this.userService=userSerive;
	}
	
	@PostMapping
	ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto dto){
		return new ResponseEntity<UserDto>(userService.addUser(dto),HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<List<UserDto>> getUser(){
		return new ResponseEntity<List<UserDto>>(userService.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<UserDto> getAllUser(@PathVariable int id){
		return new ResponseEntity<UserDto>(userService.getUser(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<UserDto> updateUser(@PathVariable int id, @Valid @RequestBody UserDto dto){
		return new  ResponseEntity<UserDto>(userService.updateUser(id, dto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
   ResponseEntity<String> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
	}

}
