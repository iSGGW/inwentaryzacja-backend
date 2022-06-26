package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interfejs RoomRepository typu public
 */
@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByFloorId(Long floorId);
}