package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.enums.AppConstants;
import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.repository.FloorRepository;
import com.example.inwentaryzacjabackend.service.FloorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Klasa FloorServiceImpl typu public
 */
@AllArgsConstructor
@NoArgsConstructor
@Service

public class FloorServiceImpl implements FloorService {

    // need to inject floor dao
    /**
     * Zmienna floorRepository typu FloorRepository
     */
    @Autowired

    private FloorRepository floorRepository;
    /**
     * Funkcja getFloor typu public ResponseEntity<Floor> pobiera Floor używając id
     * @param id Long
     * @return floor
     */
    @Override

    public ResponseEntity<Floor> getFloor(Long id) {
        Floor floor = floorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Floor", "id", id));
        return new ResponseEntity<>(floor, HttpStatus.OK);
    }
    /**
     * Funkcja addFloor typu public ResponseEntity<Floor> dodaje Floor
     * @param floor Floor
     * @return newfloor
     */
    @Override

    public ResponseEntity<Floor> addFloor(Floor floor) {
        Floor newFloor = floorRepository.save(floor);
        return new ResponseEntity<>(newFloor, HttpStatus.CREATED);
    }
    /**
     * Funkcja addFloor typu public ResponseEntity<Floor> aktualizuje Floor
     * @param id
     * @param updatedFloor
     * @return newfloor
     */
    @Override
    public ResponseEntity<Floor> updateFloor(Long id, Floor updatedFloor) {
        Floor floor = floorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Floor", "ID", id));
        floor.setBuilding(updatedFloor.getBuilding());
        floor.setLevel(updatedFloor.getLevel());
        floorRepository.save(floor);
        return new ResponseEntity<>(updatedFloor, HttpStatus.OK);
    }
    /**
     * Funkcja deleteFloor typu public ResponseEntity<ApiResponse> usuwa Floor
     * @param id
     */
    @Override
    public ResponseEntity<ApiResponse> deleteFloor(Long id) {
        Floor floor = floorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.FLOOR, AppConstants.ID, id));
        floorRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted floor"), HttpStatus.OK);

    }
    /**
     * Funkcja getAllFloorsByBuilding typu public ResponseEntity<List<Floor>> dodaje wszystkie piętra po przez budynek
     * @param buildingId
     * @return newfloor
     */
    @Override
    public ResponseEntity<List<Floor>> getAllFloorsByBuilding(Long buildingId) {
        List<Floor> floors = floorRepository.findByBuildingId(buildingId);
        return new ResponseEntity<>(floors, HttpStatus.OK);
    }
}
