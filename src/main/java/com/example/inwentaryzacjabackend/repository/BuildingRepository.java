package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interfejs BuildingRepository typu public
 */
@Repository

public interface BuildingRepository extends JpaRepository<Building, Long> {

}