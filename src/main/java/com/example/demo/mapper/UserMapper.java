package com.example.demo.mapper;

import com.example.demo.Dto.UserDto;
import com.example.demo.entity.User;

public class UserMapper {

	public static User mapToUser(UserDto dto) {
		
		User user=new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setMobileNumber(dto.getMobileNumber());
		user.setRole(dto.getRole());
		
		return user;
	}
	
	public static UserDto mapToUserDto(User user) {
		UserDto dto=new UserDto();
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setMobileNumber(user.getMobileNumber());
	    dto.setRole(user.getRole());
	    dto.setCreatedAt(user.getCreatedAt());
	    dto.setActive(user.isActive());
	    return dto;
	}
	

    public static void updateUserFromDto(UserDto dto, User user) {

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
    }
}