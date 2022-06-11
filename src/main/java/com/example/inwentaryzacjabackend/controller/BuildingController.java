package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.service.BuildingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/building/{id}")
    public ResponseEntity<Building> getBuilding(@PathVariable(name = "id") Long id) {
        Building building = buildingService.getBuilding(id);

        return new ResponseEntity< >(building, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Building> addBuilding(@Valid @RequestBody Building building) {
        Building newBuilding = buildingService.addBuilding(building);

        return new ResponseEntity< >(newBuilding, HttpStatus.CREATED);
    }

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }
}










