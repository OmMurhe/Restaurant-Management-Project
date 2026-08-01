package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.UserDto;


public interface UserService {
	
	void addUser(UserDto dto);
	List<UserDto> getAllUser();
	UserDto getUser(int id);
	UserDto updateUser(int id,UserDto dto);
	void deleteUser(int id);

}
