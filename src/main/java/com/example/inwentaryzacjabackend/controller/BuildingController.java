package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/building/{id}")
    public ResponseEntity<Building> getBuilding(@PathVariable(name = "id") Long id) {
        Building building = buildingService.getBuilding(id);
        System.out.println(building);

        return new ResponseEntity< >(building, HttpStatus.OK);
    }
}










