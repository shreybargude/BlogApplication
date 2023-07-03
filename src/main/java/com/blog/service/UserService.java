package com.blog.service;

import java.util.List;

import com.blog.dto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto user);
	
	public UserDto updateUser(UserDto user, Integer userId);
	
	public UserDto getUserById(Integer userId);
	
	public List<UserDto> getAllUsers();
	
	public void deleteUser(Integer userId);
}
