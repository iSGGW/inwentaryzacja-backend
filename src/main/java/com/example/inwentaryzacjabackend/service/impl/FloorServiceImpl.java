package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.repository.FloorRepository;
import com.example.inwentaryzacjabackend.service.FloorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class FloorServiceImpl implements FloorService {

    // need to inject floor dao
    @Autowired
    private FloorRepository floorRepository;

    @Override
    public Floor getFloor(Long id) {
        return floorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Floor", "id", id));
    }

    @Override
    public Floor addFloor(Floor floor) {
        return floorRepository.save(floor);
    }

    @Override
    public List<Floor> getAllFloorsByBuilding(Long buildingId) {
        return floorRepository.findByBuildingId(buildingId);
    }

    @Override
    public List<Floor> getAllFloors() {
        return floorRepository.findAll();
    }
}
