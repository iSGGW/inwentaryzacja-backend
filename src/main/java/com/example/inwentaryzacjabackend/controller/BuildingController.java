package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.service.BuildingService;
import com.example.inwentaryzacjabackend.service.FloorService;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/buildings")
@NoArgsConstructor
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private FloorService floorService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuilding(@PathVariable(name = "id") Long id) {
        Building building = buildingService.getBuilding(id);

        return new ResponseEntity< >(building, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Building> addBuilding(@Valid @RequestBody Building building) {
        Building newBuilding = buildingService.addBuilding(building);

        return new ResponseEntity< >(newBuilding, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{id}/floors")
    public ResponseEntity<List<Floor>> getAllFloorsByBuilding(@PathVariable(name ="id") Long id) {
        return new ResponseEntity< >(floorService.getAllFloorsByBuilding(id), HttpStatus.OK);
    }

}










