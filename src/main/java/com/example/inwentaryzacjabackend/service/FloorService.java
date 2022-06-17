package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FloorService {

    ResponseEntity<Floor> getFloor(Long id);

    ResponseEntity<Floor> addFloor(Floor floor);

    ResponseEntity<Floor> updateFloor(Long id, Floor floor);

    ResponseEntity<ApiResponse> deleteFloor(Long id);

    ResponseEntity<List<Floor>> getAllFloorsByBuilding(Long buildingId);


}
