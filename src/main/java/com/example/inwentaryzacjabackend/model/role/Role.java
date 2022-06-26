package com.example.inwentaryzacjabackend.model.role;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
/**
 *Klasa Role zawiera informacje o rolach użytkowników w aplikacji
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	/**
	 *id - zmienna typu Long zawierająca informację o wygenerowanym id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 *name - zmienna typu String zawierająca informację o nazwie roli
	 */
	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(name = "name")
	private RoleName name;
	/**
	 * Funkcja Role typu public zawiera informacje o rolach
	 * @param name  nazwa roli
	 * @return Ta funkcja zwraca informacje o roli użytkownika
	 */
	public Role(RoleName name) {
		this.name = name;
	}
}
