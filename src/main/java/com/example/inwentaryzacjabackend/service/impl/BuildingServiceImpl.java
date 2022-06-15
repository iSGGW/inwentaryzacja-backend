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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BuildingServiceImpl implements BuildingService {

    // need to inject building dao
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public ResponseEntity<Building> getBuilding(Long id) {
        Building building = buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Building", "id", id));
        return new ResponseEntity<>(building, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Building> addBuilding(Building building) {
        Building newBuilding = buildingRepository.save(building);
        return new ResponseEntity<>(newBuilding, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Building>> getAllBuildings() {
        List<Building> buildings = buildingRepository.findAll();
        return new ResponseEntity<>(buildings, HttpStatus.OK);
    }
    
    /*@Override
    public ResponseEntity<ApiResponse> deleteBuilding(Long id) {
        Building building = buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.BUILDING, AppConstants.ID, id));
            buildingRepository.deleteById(id);
            return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted building"), HttpStatus.OK);

        throw new BlogapiException(HttpStatus.UNAUTHORIZED, YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION);
    }*/

}





