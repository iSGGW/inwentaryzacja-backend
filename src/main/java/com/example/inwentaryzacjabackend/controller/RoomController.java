package com.example.inwentaryzacjabackend.controller;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.service.ItemService;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *Klasa RoomController kontroluje informacje o salach
 */
@CrossOrigin(origins = "https://20.218.104.224:8443", maxAge = 3600)
@RequestMapping("/api/rooms/")
@NoArgsConstructor
@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private ItemService itemService;
    /**
     *Klasa getRoom umożlwia podgląd sali
     * @return Zwraca informacje o wybranej sali
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable(name = "id") Long id) {
        return roomService.getRoom(id);
    }
    /**
     *Klasa getAllItemsByRoomId umożlwia podgląd wszystkich przedmiotów w sali
     * @return Zwraca listę przedmiotów w sali
     */
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}/items")
    public ResponseEntity<List<Item>> getAllItemsByRoomId(@PathVariable(name ="id") Long id) {
        return itemService.getAllItemsByRoom(id);
    }


}










