package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.User;
import com.example.inwentaryzacjabackend.security.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;
/**
 * Interfejs UserRepository typu public
 */
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(@NotBlank String username);

	Optional<User> findByEmail(@NotBlank String email);

	Boolean existsByUsername(@NotBlank String username);

	Boolean existsByEmail(@NotBlank String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	/**
	 * Funkcja getUser typu default User
	 * @param currentUser UserPrincipal
	 * @return Funkcja zwraca obecnego użytkownika
	 */
	default User getUser(UserPrincipal currentUser) {
		return getUserByName(currentUser.getUsername());
	}

	/**
	 * Funkcja getUserByName typu default User
	 * @param username String
	 * @return Funkcja zwraca użytkownika używając Username
	 */
	default User getUserByName(String username) {
		return findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
	}
}
