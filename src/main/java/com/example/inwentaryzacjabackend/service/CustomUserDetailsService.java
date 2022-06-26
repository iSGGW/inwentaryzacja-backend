package com.example.inwentaryzacjabackend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *  Interfejs CustomUserDetailsService obsługuje walidacje przy pobieraniu użytkownika
 */

public interface CustomUserDetailsService {

	UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException;

	UserDetails loadUserById(Long id);

}