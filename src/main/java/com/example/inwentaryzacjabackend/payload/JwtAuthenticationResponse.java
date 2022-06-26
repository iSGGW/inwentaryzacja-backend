package com.example.inwentaryzacjabackend.payload;

import lombok.Data;
/**
 *Klasa JwtAuthenticationResponse przechowuje informacje o uwierzytelnieniu
 */
@Data
public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";

	public JwtAuthenticationResponse(String accessToken) {
		this.accessToken = accessToken;
	}

}
