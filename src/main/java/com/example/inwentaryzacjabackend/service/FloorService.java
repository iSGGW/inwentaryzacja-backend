package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Floor;

import java.util.List;

// response entity vs pojo, to be decided

public interface FloorService {

    List<Floor> getAllFloors();

    Floor getFloor(Long id);

    Floor addFloor(Floor floor);

    List<Floor> getAllFloorsByBuilding(Long buildingId);


}
