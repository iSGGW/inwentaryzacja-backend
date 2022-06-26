package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.model.User;
import com.example.inwentaryzacjabackend.repository.UserRepository;
import com.example.inwentaryzacjabackend.security.UserPrincipal;
import com.example.inwentaryzacjabackend.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
/**
 * Klasa CustomUserDetailsServiceImpl typu public
 */
@Service

public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {
	@Autowired
	private UserRepository userRepository;
	/**
	 * Klasa loadUserByUsername typu UserDetails wczytuje użytkownika poprzez username lub email
	 * @param usernameOrEmail nazwa uzytkownia lub email uzytkownika
	 */
	@Override
	@Transactional

	public UserDetails loadUserByUsername(String usernameOrEmail) {
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with this username or email: %s", usernameOrEmail)));
		return UserPrincipal.create(user);
	}
	/**
	 * Klasa loadUserByUsername typu UserDetails wczytuje użytkownika po przez id
	 * @param id id uzytkownika
	 */
	@Override
	@Transactional

	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with id: %s", id)));

		return UserPrincipal.create(user);
	}
}
