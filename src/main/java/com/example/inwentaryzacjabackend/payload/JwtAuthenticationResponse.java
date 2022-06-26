package com.example.inwentaryzacjabackend.payload;

import lombok.Data;
/**
 *Klasa JwtAuthenticationResponse przechowuje informacje o uwierzytelnieniu
 */
@Data
public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private String tokenBearerRole;

	public JwtAuthenticationResponse(String accessToken, String tokenBearerRole) {
		this.accessToken = accessToken;
		this.tokenBearerRole = tokenBearerRole;
	}

}
