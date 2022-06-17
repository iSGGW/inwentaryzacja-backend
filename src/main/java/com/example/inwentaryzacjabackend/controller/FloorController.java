package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Floor;
import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.service.FloorService;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/floors/")
@NoArgsConstructor
@RestController
public class FloorController {

    @Autowired
    private FloorService floorService;

    @Autowired
    private RoomService roomService;

    @RequestMapping("/{id}")
    public ResponseEntity<Floor> getFloor(@PathVariable(name = "id") Long id) {
        Floor floor = floorService.getFloor(id);

        return new ResponseEntity< >(floor, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<Room>> getAllRoomsByFloor(@PathVariable(name ="id") Long id) {
        List<Room> roomsByFloor = roomService.getAllRoomsByFloor(id);
        return new ResponseEntity<>(roomsByFloor, HttpStatus.OK);
    }
}
