package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Building;

import java.util.List;

public interface BuildingService {

    Building getBuilding(Long id);

    Building addBuilding(Building building);

    List<Building> getAllBuildings();



}
