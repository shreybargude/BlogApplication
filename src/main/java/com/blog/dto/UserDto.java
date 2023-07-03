package com.blog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Name must be min of 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 characters and max of 10 characters !!")
	private String password;
	
	@NotEmpty
	private String about;
}
