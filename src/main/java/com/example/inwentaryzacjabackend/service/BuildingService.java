package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Interfejs BuildingService obsługuje akcje CRUD dla encji Building
 */
public interface BuildingService {

    ResponseEntity<Building> getBuilding(Long id);

    ResponseEntity<Building> addBuilding(Building building);

    ResponseEntity<List<Building>> getAllBuildings();

    ResponseEntity<ApiResponse> deleteBuilding(Long id);

    ResponseEntity<Building> updateBuilding(Long id, Building building);



}
