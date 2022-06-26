package com.example.inwentaryzacjabackend.service;

import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *  Interfejs ItemService obsługuje akcje CRUD dla encji Item
 */


public interface ItemService {

    ResponseEntity<Item> getItem(Long id);

    ResponseEntity<Item> addItem(Item item);

    ResponseEntity<List<Item>> getAllItems();

    ResponseEntity<ApiResponse> deleteItem(Long id);

    ResponseEntity<Item> updateItem(Long id, Item item);

    ResponseEntity<List<Item>> getAllItemsByRoom(Long roomId);
}