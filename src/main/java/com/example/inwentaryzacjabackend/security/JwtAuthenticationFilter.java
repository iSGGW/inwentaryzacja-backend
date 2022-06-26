package com.example.inwentaryzacjabackend.security;

import com.example.inwentaryzacjabackend.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Klasa JwtAuthenticationFilter typu public
 *
 */
@Component

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	/**
	 * LOGGER typu private static final Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	/**
	 * Zmienna tokenProvider typu private JwtTokenProvider
	 */
	@Autowired

	private JwtTokenProvider tokenProvider;
	/**
	 * Zmienna customUserDetailsService typu private CustomUserDetailsService
	 */
	@Autowired

	private CustomUserDetailsService customUserDetailsService;
	/**
	 * Funkcja doFilterInternal typu protected void
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param filterChain FilterChain
	 */
	@Override

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = getJwtFromRequest(request);

			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt) && !jwt.isEmpty()) {
				Long userId = tokenProvider.getUserIdFromJWT(jwt);
				UserDetails userDetails = customUserDetailsService.loadUserById(userId);
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				LOGGER.info("Authentication token" + authenticationToken);
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		} catch (Exception ex) {
			LOGGER.error("Could not set user authentication in security context", ex);
		}

		filterChain.doFilter(request, response);
	}

	/**
	 * Funkcja getJwtFromRequest typu private String
	 * @param request HttpServletRequest
	 * @return Zwraca 7 lub null
	 */
	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
}
