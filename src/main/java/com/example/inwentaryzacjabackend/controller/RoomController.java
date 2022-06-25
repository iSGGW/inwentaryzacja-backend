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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "https://20.218.104.224:8443", maxAge = 3600)
@RequestMapping("/api/rooms/")
@NoArgsConstructor
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ItemService itemService;

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable(name = "id") Long id) {
        return roomService.getRoom(id);
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}/items")
    public ResponseEntity<List<Item>> getAllItemsByRoomId(@PathVariable(name ="id") Long id) {
        return itemService.getAllItemsByRoom(id);
    }


}










