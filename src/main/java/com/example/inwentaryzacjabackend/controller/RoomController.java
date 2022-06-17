package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.service.ItemService;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@NoArgsConstructor
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(roomService.getRoom(id), HttpStatus.OK);
    }

    /*
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<foo>> getAllFoos() {
        return fooService.getAllBuildings();
    }*/
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<Item>> getAllItemsByRoom(@PathVariable(name ="id") Long id) {
        ResponseEntity<List<Item>> itemsByRoom = new ResponseEntity<>(itemService.getAllItemsByRoomId(id), HttpStatus.OK);
        return itemsByRoom;
    }


}










