package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}