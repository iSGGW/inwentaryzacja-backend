package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.enums.AppConstants;
import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.repository.RoomRepository;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Klasa RoomServiceImpl
 */
@AllArgsConstructor
@NoArgsConstructor
@Service

public class RoomServiceImpl implements RoomService {
    /**
     * Zmienna roomRepository typu private RoomRepository
     */
    @Autowired

    private RoomRepository roomRepository;
    /**
     * Funkcja getRoom typu public ResponseEntity<Room>
     * @param id ID pokoju
     * @return room
     */
    @Override

    public ResponseEntity<Room> getRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
    /**
     * Funkcja addRoom typu public ResponseEntity<Room>
     * @param room
     * @return room
     */
    @Override

    public ResponseEntity<Room> addRoom(Room room) {
        roomRepository.save(room);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }
    /**
     * Funkcja getAllRoomsByFloor typu public ResponseEntity<List<Room>>
     * @param floorId
     */
    @Override

    public ResponseEntity<List<Room>> getAllRoomsByFloor(Long floorId) {
        return new ResponseEntity<>(roomRepository.findByFloorId(floorId), HttpStatus.OK);
    }
    /**
     * Funkcja updateRoom typu public ResponseEntity<Room>
     * @param id
     * @param updatedRoom
     * @return updatedRoom
     */
    @Override

    public ResponseEntity<Room> updateRoom(Long id, Room updatedRoom) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room", "ID", id));
        room.setType(updatedRoom.getType());
        room.setFloor(updatedRoom.getFloor());
        room.setNumber(updatedRoom.getNumber());
        roomRepository.save(room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }
    /**
     * Funkcja deleteRoom typu  public ResponseEntity<ApiResponse>
     * @param id
     */
    @Override

    public ResponseEntity<ApiResponse> deleteRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.ROOM, AppConstants.ID, id));
        roomRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted room"), HttpStatus.OK);

    }
}