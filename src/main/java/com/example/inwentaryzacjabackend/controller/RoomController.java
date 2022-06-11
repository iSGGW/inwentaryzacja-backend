package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable(name = "id") Long id) {
        Room room = roomService.getRoom(id);

        return new ResponseEntity< >(room, HttpStatus.OK);
    }
// TO DO why it is not working
    /*@PostMapping
    public ResponseEntity<Room> addRoom(@Valid @RequestBody Room room) {
        Room newRoom = roomService.addRoom(room);

        return new ResponseEntity< >(newRoom, HttpStatus.CREATED);
    }*/
}










