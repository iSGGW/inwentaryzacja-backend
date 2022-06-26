package com.example.inwentaryzacjabackend.service.impl;


import com.example.inwentaryzacjabackend.enums.AppConstants;
import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.repository.BuildingRepository;
import com.example.inwentaryzacjabackend.service.BuildingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service

/**
 * Klasa BuildingServiceImpl typu public
 *
 */
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    /**
     * Funkcja getBuilding typu public pobiera Budynek przez id
     * @param id ID budynku
     * @return building
     */
    @Override
    public ResponseEntity<Building> getBuilding(Long id) {
        Building building = buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Building", "id", id));
        return new ResponseEntity<>(building, HttpStatus.OK);
    }

    /**
     * Funkcja addBuilding typu public dodaje Budynek
     * @param building
     * @return newBuilding
     */
    @Override
    public ResponseEntity<Building> addBuilding(Building building) {
        Building newBuilding = buildingRepository.save(building);
        return new ResponseEntity<>(newBuilding, HttpStatus.CREATED);
    }

    /**
     * Funkcja getAllBuildings typu public pobiera wszystkie Budynki
     * @return buildings
     */
    @Override
    public ResponseEntity<List<Building>> getAllBuildings() {
        List<Building> buildings = buildingRepository.findAll();
        return new ResponseEntity<>(buildings, HttpStatus.OK);
    }

    /**
     * Funkcja updateBuilding typu public aktualizuje Budynek
     * @param id ID budynku
     * @param updatedBuilding budynek do zaktualizowania
     * @return updatedBuilding
     */
    @Override
    public ResponseEntity<Building> updateBuilding(Long id, Building updatedBuilding) {
        Building building = buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Building", "ID", id));
        building.setAddress(updatedBuilding.getAddress());
        building.setName(updatedBuilding.getName());
        building.setNumber(updatedBuilding.getNumber());
        buildingRepository.save(building);
        return new ResponseEntity<>(updatedBuilding, HttpStatus.OK);
    }

    /**
     * Funkcja deleteBuilding typu public usuwa Budynek
     * @param id ID budynku do usunięcia
     */
    @Override
    public ResponseEntity<ApiResponse> deleteBuilding(Long id) {
        Building building = buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.BUILDING, AppConstants.ID, id));
        buildingRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted building"), HttpStatus.OK);

    }

}





