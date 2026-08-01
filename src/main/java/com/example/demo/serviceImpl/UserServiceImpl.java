package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
	public void addUser(UserDto dto) {
		if(userRepo.existsByEmail(dto.getEmail())) {
			throw new UserServiceException("User is already exists",HttpStatus.CONFLICT);
		}
	
		User user=UserMapper.mapToUser(dto);
		user.setCreatedAt(LocalDate.now());
		user.setActive(true);
		userRepo.save(user);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users=userRepo.findAll();
		if(users.isEmpty()) {
			throw new UserServiceException("User not found",HttpStatus.NOT_FOUND);
		}
		
		User user=
	}

	@Override
	public UserDto getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(int id, UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

}
