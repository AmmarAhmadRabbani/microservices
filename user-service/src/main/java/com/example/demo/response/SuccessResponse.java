package com.example.demo.response;

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
public class SuccessResponse {
	private boolean error;
	private String message;
	private Object data;

}
