package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.service.FloorService;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 *Klasa FloorController kontroluje informacje o piętrach
 */
@CrossOrigin(origins = "https://20.218.104.224:8443", maxAge = 3600)
@RequestMapping("/api/floors/")
@NoArgsConstructor
@RestController
public class FloorController {

    @Autowired
    private FloorService floorService;

    @Autowired
    private RoomService roomService;
    /**
     *Klasa getFloor umożlwia podgląd pięter
     * @return Zwraca informacje o wybranym piętrze
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @RequestMapping("/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable(name = "id") Long id) {
        return floorService.getFloor(id);
    }
    /**
     *Klasa addFloor umożlwia dodanie informacji o piętrze
     * @return Zwraca informację o dodaniu nowego piętra
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Floor> addFloor(@Valid @RequestBody Floor floor) {
        return floorService.addFloor(floor);
    }
    /**
     *Klasa updateFloor umożlwia aktualizację informacji o piętrze
     * @return Zwraca informację o aktualizacji danych
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Floor> updateFloor(@PathVariable(name = "id") Long id, @Valid @RequestBody Floor updatedFloor) {
        return floorService.updateFloor(id, updatedFloor);
    }
    /**
     *Klasa getAllRoomsByFloor umożlwia podgląd wszystkich sal na piętrze
     * @return Zwraca listę sal na piętrze
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<Room>> getAllRoomsByFloor(@PathVariable(name ="id") Long id) {
        return roomService.getAllRoomsByFloor(id);
    }
}
