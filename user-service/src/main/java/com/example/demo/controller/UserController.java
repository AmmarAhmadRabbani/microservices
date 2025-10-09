package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<SuccessResponse> register(@RequestBody UserDto userDto) {
		UserDto register = userService.register(userDto);
		if (register != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Registered Successfull", register), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Registered", null), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/login")
	public ResponseEntity<SuccessResponse> loginFull(@RequestBody LoginDto loginDto) {
		UserDto loginFull = userService.loginFull(loginDto);
		if (loginFull != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Welcome", loginFull), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Sorry", null), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/logIn")
	public ResponseEntity<SuccessResponse> login(@RequestBody LoginDto loginDto) {
		String login = userService.login(loginDto);
		if (!login.isEmpty()) {
			return new ResponseEntity<>(new SuccessResponse(false, "Success", login), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Success", null), HttpStatus.BAD_REQUEST);

	}
//	<dependency>   <groupId>org.springframework.boot</groupId>   <artifactId>
//	spring-boot-starter-security</artifactId>
//</dependency>

}
