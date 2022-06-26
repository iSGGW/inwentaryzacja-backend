package com.example.inwentaryzacjabackend.security;

import com.example.inwentaryzacjabackend.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * UserPrincipal typu public class
 */
public class UserPrincipal implements UserDetails {
	/**
	 * Zmienna serialVersionUID typu private static final long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Zmienna id typu private Long
	 */
	private Long id;

	/**
	 * Zmienna firstName typu private String
	 */
	private String firstName;

	/**
	 * Zmienna lastName typu private String
	 */
	private String lastName;
	/**
	 * Zmienna username typu private String
	 */
	private String username;
	/**
	 * Zmienna email typu private String
	 */
	@JsonIgnore

	private String email;
	/**
	 * Zmienna password typu private String
	 */
	@JsonIgnore

	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * Funkcja UserPrincipal typu public
	 * @param id Long
	 * @param firstName String
	 * @param lastName String
	 * @param username String
	 * @param email String
	 * @param password String
	 * @param authorities Collection<? extends GrantedAuthority>
	 */
	public UserPrincipal(Long id, String firstName, String lastName, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;

		if (authorities == null) {
			this.authorities = null;
		} else {
			this.authorities = new ArrayList<>(authorities);
		}
	}

	/**
	 * Funkcja create typu public static
	 * @param user User
	 * @return Funkcja zwraca UserPrincipal
	 */
	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserPrincipal(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(),
				user.getEmail(), user.getPassword(), authorities);
	}

	/**
	 * Funkcja getId typu public Long
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Funkcja getEmail typu public String
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 *Funkcja getAuthorities typu public Collection<? extends GrantedAuthority>
	 * @return Funkcja authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities == null ? null : new ArrayList<>(authorities);
	}
	/**
	 * Funkcja getPassword typu public String
	 * @return password
	 */
	@Override

	public String getPassword() {
		return password;
	}
	/**
	 * Funkcja getUsername typu public String
	 * @return username
	 */
	@Override

	public String getUsername() {
		return username;
	}
	/**
	 * Funkcja isAccountNonExpired typu public boolean
	 * @return true
	 */
	@Override

	public boolean isAccountNonExpired() {
		return true;
	}
	/**
	 * Funkcja isAccountNonLocked typu public boolean
	 * @return true
	 */
	@Override

	public boolean isAccountNonLocked() {
		return true;
	}
	/**
	 * Funkcja isCredentialsNonExpired typu public boolean
	 * @return true
	 */
	@Override

	public boolean isCredentialsNonExpired() {
		return true;
	}
	/**
	 * Funkcja isEnabled typu public boolean
	 * @return true
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * Funkcja equals typu public boolean
	 * @param object Object
	 * @return Zmienna typu boolean
	 */
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) object;
		return Objects.equals(id, that.id);
	}

	/**
	 * Funkcja hashCode typu public int
	 * @return Kod hash objektu
	 */
	public int hashCode() {
		return Objects.hash(id);
	}
	/**
	 * Funkcja getFirstName typu public String
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Funkcja getLastName typu public String
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
}
