package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BuildingService {

    ResponseEntity<Building> getBuilding(Long id);

    ResponseEntity<Building> addBuilding(Building building);

    ResponseEntity<List<Building>> getAllBuildings();

    //ResponseEntity<ApiResponse> deleteBuilding(Long id);

    //ResponseEntity<ApiResponse> editBuilding(Long id);



}
