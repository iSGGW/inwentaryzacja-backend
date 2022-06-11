package com.example.inwentaryzacjabackend.repository;

import com.example.inwentaryzacjabackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}