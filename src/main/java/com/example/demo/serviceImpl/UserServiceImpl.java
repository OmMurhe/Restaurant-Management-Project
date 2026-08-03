package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserServiceException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositary.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepo;
	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo=userRepo;
	}
	

	@Override
	public UserDto addUser(UserDto dto) {
		if(userRepo.existsByEmail(dto.getEmail())) {
			throw new UserServiceException("User is already exists",HttpStatus.CONFLICT);
		}
		if(userRepo.existsByMobileNumber(dto.getMobileNumber())) {
			throw new UserServiceException("Mobile Number is already exists",HttpStatus.CONFLICT);
		}
	
		User user=UserMapper.mapToUser(dto);
		user.setCreatedAt(LocalDate.now());
		user.setActive(true);
		
		try {
		User u=userRepo.save(user);
		return UserMapper.mapToUserDto(u);
		}
		catch (DataIntegrityViolationException e) {
			throw new UserServiceException("Duplicate email or mobile", HttpStatus.CONFLICT);
		}
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users=userRepo.findAll();
		List<UserDto> usersDto=users.stream().map(user -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
		return usersDto;
	}

	@Override
	public UserDto getUser(int id) {
		User user=userRepo.findById(id).orElseThrow(()-> new UserServiceException("User not found", HttpStatus.NOT_FOUND));
		UserDto userDto=UserMapper.mapToUserDto(user);
		return userDto;
		
	}

	@Override
	public UserDto updateUser(int id, UserDto dto) {
		User user=userRepo.findById(id).orElseThrow(()-> new UserServiceException("User not found", HttpStatus.NOT_FOUND));
		
		if (userRepo.existsByEmailAndIdNot(dto.getEmail(), id)) {
		    throw new UserServiceException("Email already exists", HttpStatus.CONFLICT);
		}

		if (userRepo.existsByMobileNumberAndIdNot(dto.getMobileNumber(), id)) {
		    throw new UserServiceException("Mobile number already exists", HttpStatus.CONFLICT);
		}
		  UserMapper.updateUserFromDto(dto, user);
		
		try {
			
			 User updatedUser = userRepo.save(user);
             return UserMapper.mapToUserDto(updatedUser);
		
		}catch (DataIntegrityViolationException e) {
			throw new UserServiceException("Duplicate email or mobile or Password ",HttpStatus.CONFLICT);
		}
	}

	@Override
	public void deleteUser(int id) {
		User user=userRepo.findById(id).orElseThrow(()-> new UserServiceException("User not found", HttpStatus.NOT_FOUND));
		userRepo.deleteById(id);
		
	}

}
