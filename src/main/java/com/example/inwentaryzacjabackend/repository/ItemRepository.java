package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interfejs ItemRepository typu public
 */
@Repository

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByRoomId(Long roomId);

}