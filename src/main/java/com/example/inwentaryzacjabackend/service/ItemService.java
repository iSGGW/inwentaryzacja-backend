package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<Item> getItem(Long id);

    ResponseEntity<Item> addItem(Item item, String username);

    ResponseEntity<List<Item>> getAllItems();

    ResponseEntity<ApiResponse> deleteItem(Long id);

    ResponseEntity<Item> updateItem(Long id, Item item, String username);

    ResponseEntity<List<Item>> getAllItemsByRoom(Long roomId);
}