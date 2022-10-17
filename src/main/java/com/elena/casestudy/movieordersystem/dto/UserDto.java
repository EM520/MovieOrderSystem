package com.elena.casestudy.movieordersystem.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
@Data
public class UserDto {
	
		private Long id;
		@NotEmpty
		private String firstName;
		@NotEmpty
		private String lastName;
		@NotEmpty(message = "Email should not be empty")
		@Email
		private String email;
		@NotEmpty
		private String password;
	

}
