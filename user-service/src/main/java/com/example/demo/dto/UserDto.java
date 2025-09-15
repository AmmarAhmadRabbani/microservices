package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String name;
	private String emailId;
	private String password;

}
