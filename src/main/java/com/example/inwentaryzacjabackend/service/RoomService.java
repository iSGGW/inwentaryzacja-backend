package com.example.inwentaryzacjabackend.service;

// https://www.youtube.com/watch?v=2up_Eq6r6Ko

import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoomService {

    ResponseEntity<Room> getRoom(Long id);

    ResponseEntity<Room> addRoom(Room room);

    ResponseEntity<List<Room>> getAllRoomsByFloor(Long floorId);

    ResponseEntity<ApiResponse> deleteRoom(Long id);

    ResponseEntity<Room> updateRoom(Long id, Room room);


}
