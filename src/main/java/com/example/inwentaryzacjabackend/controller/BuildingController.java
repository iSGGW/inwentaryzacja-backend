package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Building;
import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.service.BuildingService;
import com.example.inwentaryzacjabackend.service.FloorService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 *Klasa BuildingController kontroluje informacje o gmachach
 */
@CrossOrigin(origins = "https://20.218.104.224:8443", maxAge = 3600)
@RequestMapping("/api/buildings/")
@NoArgsConstructor
@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private FloorService floorService;
    /**
     *Klasa getBuilding umożlwia podgląd gmachu
     * @return Zwraca informacje o wybranym gamchu
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuilding(@PathVariable(name = "id") Long id) {
        return buildingService.getBuilding(id);
    }
    /**
     *Klasa addBuilding umożlwia dodanie informacji o gmachu
     * @return Zwraca informację o dodaniu nowego gmachu
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Building> addBuilding(@Valid @RequestBody Building building) {
        return buildingService.addBuilding(building);
    }
    /**
     *Klasa updateBuilding umożlwia aktualizację informacji o gmachu
     * @return Zwraca informację o aktualizacji danych
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Building> updateBuilding(@PathVariable(name = "id") Long id, @Valid @RequestBody Building updatedBuilding) {
        return buildingService.updateBuilding(id, updatedBuilding);
    }
    /**
     *Klasa deleteBuilding umożlwia usunięcie dodanego gmachu
     * @return Zwraca informację o usunięciu gmachu
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteBuilding(@PathVariable(name = "id") Long id) {
        return buildingService.deleteBuilding(id);
    }
    /**
     *Klasa getAllBuildings umożlwia podgląd wszystkich gmachów
     * @return Zwraca listę istniejących gmachów
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Building>> getAllBuildings() {
        return buildingService.getAllBuildings();
    }
    /**
     *Klasa getAllFloorsByBuilding umożlwia podgląd wszystkich pięter w gmachu
     * @return Zwraca listę pięter w gmachu
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}/floors")
    public ResponseEntity<List<Floor>> getAllFloorsByBuilding(@PathVariable(name ="id") Long id) {
        return floorService.getAllFloorsByBuilding(id);
    }
}










