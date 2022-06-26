package com.example.inwentaryzacjabackend.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Klasa JwtAuthenticationEntryPoint typu public
 */
@Component

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	/**
	 * Zmienna LOGGER typu private static final Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
	/**
	 * Funkcja commence typu public void
	 * @param httpServletRequest typu HttpServletRequest
	 * @param httpServletResponse typu HttpServletResponse
	 * @param e typu AuthenticationException
	 */
	@Override

	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
			throws IOException, ServletException {
		LOGGER.error("Responding with unauthorized error. Message - {}", e.getMessage());
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Sorry, You're not authorized to access this resource.");
	}
}
