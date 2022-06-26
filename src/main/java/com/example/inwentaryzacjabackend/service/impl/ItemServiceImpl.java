package com.example.inwentaryzacjabackend.service.impl;

import com.example.inwentaryzacjabackend.enums.AppConstants;
import com.example.inwentaryzacjabackend.exception.ResourceNotFoundException;
import com.example.inwentaryzacjabackend.model.Item;
import com.example.inwentaryzacjabackend.payload.ApiResponse;
import com.example.inwentaryzacjabackend.repository.ItemRepository;
import com.example.inwentaryzacjabackend.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Klasa ItemServiceImpl
 */
@AllArgsConstructor
@NoArgsConstructor
@Service


public class ItemServiceImpl implements ItemService {
    /**
     * Zmienna itemRepository typu private ItemRepository
     */
    @Autowired

    private ItemRepository itemRepository;
    /**
     * Funkcja getItem typu public ResponseEntity<Item>
     * @param id
     * @return item
     */
    @Override

    public ResponseEntity<Item> getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    /**
     * Funkcja addItem typu public ResponseEntity<Item>
     * @param item
     * @return newitem
     */
    @Override

    public ResponseEntity<Item> addItem(Item item) {
        Item newItem = itemRepository.save(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
    /**
     * Funkcja getAllItems typu public ResponseEntity<List<Item>>
     * @return items
     */
    @Override

    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    /**
     * Funkcja updateItem typu public ResponseEntity<Item>
     * @param id
     * @param updatedItem
     * @return updatedItem
     */
    @Override

    public ResponseEntity<Item> updateItem(Long id, Item updatedItem) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "ID", id));
        item.setManufacturer(updatedItem.getManufacturer());
        item.setName(updatedItem.getName());
        item.setRoom(updatedItem.getRoom());
        item.setSerialNumber(updatedItem.getSerialNumber());
        item.setStatus(updatedItem.getStatus());
        item.setType(updatedItem.getStatus());
        itemRepository.save(item);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    /**
     * Funkcja updateItem typu public ResponseEntity<Item>
     * @param id
     * @return updatedItem
     */
    @Override

    public ResponseEntity<ApiResponse> deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.ITEM, AppConstants.ID, id));
        itemRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted item"), HttpStatus.OK);

    }
    /**
     * Funkcja getAllItemsByRoom typu public ResponseEntity<List<Item>>
     * @param roomId
     * @return items
     */
    @Override

    public ResponseEntity<List<Item>> getAllItemsByRoom(Long roomId) {
        List<Item> items = itemRepository.findByRoomId(roomId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}