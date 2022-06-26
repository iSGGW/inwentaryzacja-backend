package com.example.inwentaryzacjabackend.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Klasa JwtTokenProvider typu public
 */
@Component

public class JwtTokenProvider {
	/**
	 * Zmienna LOGGER typu private static final Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
	/**
	 * Zmienna jwtSecret typu private String
	 */
	@Value(value = "${app.jwtSecret}")

	private String jwtSecret;
	/**
	 * Zmienna jwtExpirationInMs typu private int
	 */
	@Value(value = "${app.jwtExpirationInMs}")

	private int jwtExpirationInMs;

	/**
	 * Funkcja generateToken typu public String
	 * @param authentication Authentication
	 * @return Funkcja generuje token
	 */
	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

		return Jwts.builder()
				.setSubject(Long.toString(userPrincipal.getId()))
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	/**
	 * Funkcja getUserIdFromJWT typu public Long
	 * @param token String
	 * @return Funkcja zwraca ID użytkownika
	 */
	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();

		return Long.valueOf(claims.getSubject());
	}

	/**
	 * Funkcja validateToken typu public boolean
	 * @param authToken String
	 * @return Funkcja sprawdza poprawnośc tokenu. Wartość zwracana typu boolean
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			LOGGER.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			LOGGER.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			LOGGER.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			LOGGER.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			LOGGER.error("JWT claims string is empty");
		}
		return false;
	}

}
