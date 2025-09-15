package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;

public interface UserService {
	public UserDto register(UserDto userDto);

	public String login(LoginDto loginDto);

}
