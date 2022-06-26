package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.model.role.Role;
import com.example.inwentaryzacjabackend.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
/**
 * Interfejs RoleRepository typu public
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
