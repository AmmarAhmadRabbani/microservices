package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private MailProperties mailProperties;

	@Override
	public UserDto register(UserDto userDto) {
		Optional<User> user = userRepository.findByEmailId(userDto.getEmailId());
		if (user.isPresent()) {
			throw new UserNotFoundException("User Already Registered");
		}
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("ammarthegenious@gmail.com");
		simpleMailMessage.setTo(userDto.getEmailId());
		simpleMailMessage.setSubject("Regestred Successful");
		simpleMailMessage.setText("Dear" + " " + userDto.getName() + "," +  "\n" + "You are Registered Successfully!" + "\n"
				+ "Thanks & Regards" + "," + "\n" + "Teams.");
		javaMailSender.send(simpleMailMessage);
		User newUser = new User();
		BeanUtils.copyProperties(userDto, newUser);
		userRepository.save(newUser);
//		Password Not Show in it's orignal form on screen
		newUser.setPassword("*****");
		BeanUtils.copyProperties(newUser, userDto);
		return userDto;
	}

	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
