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

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ResponseEntity<Item> getItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> addItem(Item item, String username) {
        item.setCreatedBy(username);
        item.setLastUpdatedBy(username);
        Item newItem = itemRepository.save(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> updateItem(Long id, Item updatedItem, String username) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "ID", id));
        item.setRoom(updatedItem.getRoom());
        item.setName(updatedItem.getName());
        item.setType(updatedItem.getType());
        item.setManufacturer(updatedItem.getManufacturer());
        item.setSerialNumber(updatedItem.getSerialNumber());
        item.setStatus(updatedItem.getStatus());
        item.setCreationDate(updatedItem.getCreationDate());
        item.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        item.setCreatedBy(updatedItem.getCreatedBy());
        item.setLastUpdatedBy(username);

        itemRepository.save(item);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteItem(Long id) {
        itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.ITEM, AppConstants.ID, id));
        itemRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted item"), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<Item>> getAllItemsByRoom(Long roomId) {
        List<Item> items = itemRepository.findByRoomId(roomId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}