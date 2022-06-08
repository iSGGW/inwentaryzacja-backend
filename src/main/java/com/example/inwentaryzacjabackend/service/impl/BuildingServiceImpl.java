package com.example.inwentaryzacjabackend.service.impl;


import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.repository.BuildingRepository;
import com.example.inwentaryzacjabackend.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {

    // need to inject building dao
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Building getBuilding(Long id) {
        return buildingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Building", "id", id));
    }

}





