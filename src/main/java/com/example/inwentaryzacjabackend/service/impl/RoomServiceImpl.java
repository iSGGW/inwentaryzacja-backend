package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Room;
import com.example.inwentaryzacjabackend.repository.RoomRepository;
import com.example.inwentaryzacjabackend.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room getRoom(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRoomsByFloor(Long floorId) {
        return roomRepository.findByFloorId(floorId);
    }
}