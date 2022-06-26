package com.example.inwentaryzacjabackend.model;

import com.example.inwentaryzacjabackend.model.role.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *Klasa User służy do przechowywania danych użytkownika
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class User {
	private static final long serialVersionUID = 1L;
	/**
	 *id - zmienna typu Long zawierająca informację o ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	/**
	 *firstName - zmienna typu String zawierająca informację o imieniu użytkownika
	 */
	@NotBlank
	@Column(name = "first_name")
	@Size(max = 40)
	private String firstName;
	/**
	 *lastName - zmienna typu String zawierająca informację o nazwisku użytkownika
	 */
	@NotBlank
	@Column(name = "last_name")
	@Size(max = 40)
	private String lastName;
	/**
	 *username - zmienna typu String zawierająca informację o nazwie użytkownika
	 */
	@NotBlank
	@Column(name = "username")
	@Size(max = 15)
	private String username;
	/**
	 *password - zmienna typu String zawierająca informację o haśle użytkownika
	 */
	@NotBlank
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Size(max = 100)
	@Column(name = "password")
	private String password;
	/**
	 *email - zmienna typu String zawierająca informację o adresie mailowym użytkownika
	 */
	@NotBlank
	@NaturalId
	@Size(max = 40)
	@Column(name = "email")
	@Email
	private String email;
	/**
	 *roles - lista dostępnych ról użytkownika
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	/**
	 * Funkcja User typu public zawiera informacje o danych użytkownika

	 * @param firstName  imię użytkownika
	 * @param lastName  nazwisko użytkownika
	 * @param username  nazwa użytkownika
	 * @param email  adres mailowy użytkownika
	 * @param password  hasło użytkownika
	 */
	public User(String firstName, String lastName, String username, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	/**
	 * Funkcja getRoles typu public zawiera listę dostępnych ról użytkownika
	 * @return Ta funkcja zwraca listę dostępnych ról użytkownika
	 */
	public List<Role> getRoles() {

		return roles == null ? null : new ArrayList<>(roles);
	}
	/**
	 * Funkcja setRoles typu public void służy do przypisywania roli użytkownikowi
	 * @param roles  rola użytkownika
	 */
	public void setRoles(List<Role> roles) {

		if (roles == null) {
			this.roles = null;
		} else {
			this.roles = Collections.unmodifiableList(roles);
		}
	}
}
