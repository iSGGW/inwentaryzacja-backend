package com.example.inwentaryzacjabackend.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
/**
 *Klasa LoginRequest przechowuje informacje o logowaniu
 */
@Data
public class LoginRequest {
	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;
}
