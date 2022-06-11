package com.example.inwentaryzacjabackend.service;

// https://www.youtube.com/watch?v=2up_Eq6r6Ko

import com.example.inwentaryzacjabackend.model.Room;

public interface RoomService {

    Room getRoom(Long id);

    Room addRoom(Room room);

}
